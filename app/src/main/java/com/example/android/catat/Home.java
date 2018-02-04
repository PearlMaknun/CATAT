package com.example.android.catat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    DatabaseHelper myDb;
    ArrayList<Catatan> noteList;
    ListView listView;
    Catatan note;
    Cursor data;
    int numRows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        myDb = new DatabaseHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddNote.class);
                startActivity(intent);
            }
        });

        noteList = new ArrayList<>();
        data = myDb.getByDatetime();
        numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(Home.this, "Catat! is empty!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                note = new Catatan(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8));
                noteList.add(note);
            }
            AdapterCatatan adapter = new AdapterCatatan(this, R.layout.adapter_catatan, noteList);
            listView = (ListView) findViewById(R.id.lv_catat);
            listView.setAdapter(adapter);

            //onClick di list
            listView.setOnItemClickListener(selectData);

        }
    }

    private AdapterView.OnItemClickListener selectData = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Bundle b = new Bundle();
            b.putString("ID", noteList.get(position).getID());
            b.putString("JUDUL", noteList.get(position).getJudul());
            b.putString("LOKASI", noteList.get(position).getLokasi());
            b.putString("KATEGORI", noteList.get(position).getKategori());
            b.putString("TANGGALACARA", noteList.get(position).getTanggalAcara());
            b.putString("ISI", noteList.get(position).getDeskripsi());
            b.putString("ALARMSTATUS", noteList.get(position).getAlarmTipe());
            b.putString("FORMATTANGGAL", noteList.get(position).getFormatTanggal());
            b.putString("TGLPOS", noteList.get(position).getTanggalPos());
            //Long a = id+1;
            Intent intent = new Intent(getApplicationContext(), DetailView.class).putExtras(b);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate dari menu; disini akan menambahkan item menu pada Actionbar
        getMenuInflater().inflate(R.menu.menu_main, menu);//Memanggil file bernama menu di folder menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        myDb = new DatabaseHelper(this);
        switch (item.getItemId()) {
            case R.id.action_work:
                noteList = new ArrayList<>();
                Cursor data = myDb.getByWork();
                int numRows = data.getCount();
                if (numRows == 0) {
                    Toast.makeText(Home.this, "Catat! is empty!", Toast.LENGTH_LONG).show();
                } else {
                    while (data.moveToNext()) {
                        note = new Catatan(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8));
                        noteList.add(note);
                    }
                    AdapterCatatan adapter = new AdapterCatatan(this, R.layout.adapter_catatan, noteList);
                    listView = (ListView) findViewById(R.id.lv_catat);
                    listView.setAdapter(adapter);
                    //onClick di list
                    listView.setOnItemClickListener(selectData);
                }
                return true;
            case R.id.action_study:
                noteList = new ArrayList<>();
                data = myDb.getByStudy();
                numRows = data.getCount();
                if (numRows == 0){
                    Toast.makeText(Home.this, "Catat! is empty!", Toast.LENGTH_LONG).show();
                } else {
                    while (data.moveToNext()) {
                        note = new Catatan(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8));
                        noteList.add(note);
                    }
                    AdapterCatatan adapter = new AdapterCatatan(this, R.layout.adapter_catatan, noteList);
                    listView = (ListView) findViewById(R.id.lv_catat);
                    listView.setAdapter(adapter);
                    //onClick di list
                    listView.setOnItemClickListener(selectData);
                }
                return true;
            case R.id.action_family_affair:
                noteList = new ArrayList<>();
                data = myDb.getByFA();
                numRows = data.getCount();
                if (numRows == 0){
                    Toast.makeText(Home.this, "Catat! is empty!", Toast.LENGTH_LONG).show();
                } else {
                    while (data.moveToNext()) {
                        note = new Catatan(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8));
                        noteList.add(note);
                    }
                    AdapterCatatan adapter = new AdapterCatatan(this, R.layout.adapter_catatan, noteList);
                    listView = (ListView) findViewById(R.id.lv_catat);
                    listView.setAdapter(adapter);
                    //onClick di list
                    listView.setOnItemClickListener(selectData);
                }
                return true;
            case R.id.action_home:
                noteList = new ArrayList<>();
                data = myDb.getByDatetime();
                numRows = data.getCount();
                if (numRows == 0){
                    Toast.makeText(Home.this, "Catat! is empty!", Toast.LENGTH_LONG).show();
                } else {
                    while (data.moveToNext()) {
                        note = new Catatan(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8));
                        noteList.add(note);
                    }
                    AdapterCatatan adapter = new AdapterCatatan(this, R.layout.adapter_catatan, noteList);
                    listView = (ListView) findViewById(R.id.lv_catat);
                    listView.setAdapter(adapter);
                    //onClick di list
                    listView.setOnItemClickListener(selectData);
                }
                return true;
            case R.id.action_about:
                Intent intent = new Intent(Home.this, Tentang.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
