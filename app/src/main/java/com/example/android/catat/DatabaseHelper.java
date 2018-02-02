package com.example.android.catat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by DELL on 30/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="app_catat7.db";
    private static final String TABLE_NAME="catat";
    private static final int DB_VERSION = 3;
    private static final String COLUMN_1="ID";
    private static final String COLUMN_2="JUDUL";
    private static final String COLUMN_3="LOKASI";
    private static final String COLUMN_4="KATEGORI";
    private static final String COLUMN_5="TANGGALACARA";
    private static final String COLUMN_6="ISI";
    private static final String COLUMN_7="PENGINGAT";
    private static final String COLUMN_8="TGLPOSDIBUAT";
    private static final String COLUMN_9="TGLFORMAT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE catat (ID INTEGER PRIMARY KEY AUTOINCREMENT,JUDUL TEXT NOT NULL, LOKASI TEXT NOT NULL, KATEGORI TEXT NOT NULL, TANGGALACARA DATETIME NOT NULL, ISI TEXT NOT NULL, PENGINGAT TEXT NOT NULL, TGLPOSDIBUAT TIMESTAMP NOT NULL DEFAULT current_timestamp, TGLFORMAT TEXT NOT NULL);");
        db.execSQL("CREATE TRIGGER UPDATE_catat BEFORE UPDATE ON catat BEGIN UPDATE catat SET TGLPOSDIBUAT = datetime('now', 'localtime') WHERE ID = new.ID;END;");
        db.execSQL("CREATE TRIGGER INSERT_catat AFTER INSERT ON catat BEGIN UPDATE catat SET TGLPOSDIBUAT = datetime('now', 'localtime') WHERE ID = new.ID;END;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String jdl, String  lks, String kategori, String tglacara, String des, String alr, String fmrtgl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COLUMN_2, jdl);
        cV.put(COLUMN_3, lks);
        cV.put(COLUMN_4, kategori);
        cV.put(COLUMN_5, tglacara);
        cV.put(COLUMN_6, des);
        cV.put(COLUMN_7, alr);
        cV.put(COLUMN_9, fmrtgl);
        long result = db.insert(TABLE_NAME, null, cV);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String id, String jdl, String  lks, String kategori, String tglacara, String des, String alr, String fmrtgl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COLUMN_1, id);
        cV.put(COLUMN_2, jdl);
        cV.put(COLUMN_3, lks);
        cV.put(COLUMN_4, kategori);
        cV.put(COLUMN_5, tglacara);
        cV.put(COLUMN_6, des);
        cV.put(COLUMN_7, alr);
        cV.put(COLUMN_9, fmrtgl);
        db.update(TABLE_NAME, cV, "ID=?", new String[] {id});
        return true;
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getByDatetime(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM catat Order By TGLPOSDIBUAT DESC", null);
        return data;
    }

    public Cursor getByDatetimeEvent(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM catat Order By TANGGALACARA ASC", null);
        return data;
    }

    public Cursor getByWork(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM catat WHERE KATEGORI = 'Work'", null);
        return data;
    }

    public Cursor getByStudy(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM catat WHERE KATEGORI = 'Study'", null);
        return data;
    }

    public Cursor getByFA(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM catat WHERE KATEGORI = 'Family affair'", null);
        return data;
    }

    public Cursor getByID(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM catat WHERE ID = " + id, null);
        return data;
    }

    public void deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String strFilter = "ID=" + id;
        db.delete(TABLE_NAME, strFilter, null);
    }
}
