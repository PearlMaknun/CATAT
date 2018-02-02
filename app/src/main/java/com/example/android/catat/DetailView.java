package com.example.android.catat;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailView extends AppCompatActivity {

    DatabaseHelper myDb;
    Catatan note;
    String a,b,c,d,e,f,g,h,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView tglpos = (TextView) findViewById(R.id.dv_tanggaljam);
        TextView tag = (TextView) findViewById(R.id.dv_tag);
        TextView judul = (TextView) findViewById(R.id._judul);
        TextView lok = (TextView) findViewById(R.id._lokasi);
        TextView acara = (TextView) findViewById(R.id._acara);
        TextView deskripsi = (TextView) findViewById(R.id._isi);

        a = bundle.getString("ID");
        b = bundle.getString("JUDUL");
        c = bundle.getString("LOKASI");
        d = bundle.getString("KATEGORI");
        e = bundle.getString("TANGGALACARA");
        f = bundle.getString("ISI");
        g = bundle.getString("ALARMSTATUS");
        h = bundle.getString("FORMATTANGGAL");
        i = bundle.getString("TGLPOS");

        tglpos.setText(i);
        tag.setText(d);
        judul.setText(b);
        lok.setText(c);
        acara.setText(h);
        deskripsi.setText(f);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate dari menu; disini akan menambahkan item menu pada Actionbar
        getMenuInflater().inflate(R.menu.menu_detail_view, menu);//Memanggil file bernama menu di folder menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        myDb = new DatabaseHelper(this);
        switch (item.getItemId()) {
            case R.id.action_edit:
                Bundle bundle = new Bundle();
                bundle.putString("ID", a);
                bundle.putString("JUDUL", b);
                bundle.putString("LOKASI", c);
                bundle.putString("KATEGORI", d);
                bundle.putString("TANGGALACARA", e);
                bundle.putString("ISI", f);
                bundle.putString("ALARMSTATUS", g);
                bundle.putString("FORMATTANGGAL", h);
                bundle.putString("TGLPOS", i);
                Intent intent = new Intent(getApplicationContext(), EditNote.class).putExtras(bundle);
                startActivity(intent);
                return true;
            case R.id.action_delete:
                myDb.deleteData(a);
                Intent k = new Intent(this, Home.class);
                startActivity(k);
                Toast.makeText(getApplicationContext(),"Note Deleted.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
