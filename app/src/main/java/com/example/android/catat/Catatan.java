package com.example.android.catat;

/**
 * Created by DELL on 02/06/2017.
 */

public class Catatan {

    String ID;
    String Lokasi;
    String Judul;
    String TanggalAcara;
    String Kategori;
    String Deskripsi;
    String AlarmTipe;
    String TanggalPos;
    String FormatTanggal;

    public Catatan(String ID, String judul, String lokasi, String kategori, String tanggalAcara,  String deskripsi, String alarmTipe, String tanggalPos, String frmtgl) {
        this.ID = ID;
        Judul = judul;
        Lokasi = lokasi;
        TanggalAcara = tanggalAcara;
        Kategori = kategori;
        Deskripsi = deskripsi;
        AlarmTipe = alarmTipe;
        TanggalPos = tanggalPos;
        FormatTanggal = frmtgl;
    }

    public String getID() {
        return ID;
    }

    public String getJudul() {
        return Judul;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public String getTanggalAcara() {
        return TanggalAcara;
    }

    public String getKategori() {
        return Kategori;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public String getAlarmTipe() {
        return AlarmTipe;
    }

    public String getTanggalPos() {
        return TanggalPos;
    }

    public String getFormatTanggal() {
        return FormatTanggal;
    }
}
