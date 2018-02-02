package com.example.android.catat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 02/06/2017.
 */

public class AdapterCatatan extends ArrayAdapter<Catatan> {

    private LayoutInflater mInflater;
    private int mViewResourceId;
    private ArrayList<Catatan> notes;


    public AdapterCatatan(Context context, int textViewResourceId, ArrayList<Catatan> notes) {
        super(context, textViewResourceId, notes);
        this.notes = notes;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId, null);

        Catatan note = notes.get(position);

        if(note != null){
            TextView judul = (TextView) convertView.findViewById(R.id.judul);
            TextView tanggaljam = (TextView) convertView.findViewById(R.id.tanggaljam);
            TextView kategori = (TextView) convertView.findViewById(R.id.tag);
            TextView lokasi = (TextView) convertView.findViewById(R.id.tempat);

            if(judul != null){
                judul.setText(note.getJudul());
            }
            if(tanggaljam != null){
                tanggaljam.setText(note.getFormatTanggal());
            }
            if(kategori != null){
                kategori.setText(note.getKategori());
            }
            if(lokasi != null){
                lokasi.setText(note.getLokasi());
            }
        }
        return convertView;

    }
}
