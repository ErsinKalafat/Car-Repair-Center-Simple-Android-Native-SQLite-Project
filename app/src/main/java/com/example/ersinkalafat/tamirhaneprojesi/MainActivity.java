package com.example.ersinkalafat.tamirhaneprojesi;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btTamamla;
    EditText e1, e2;

    Button btListele;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btTamamla = (Button) findViewById(R.id.idBtTamamla);
        e1 = (EditText) findViewById(R.id.idMarkaET);
        e2 = (EditText) findViewById(R.id.idFiyatET);


        btTamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marka, fiyat;

                marka = e1.getText().toString();
                fiyat = e2.getText().toString();

                Veritabani db = new Veritabani(getApplicationContext());
                db.aracEkle(marka,fiyat);
                db.close();
                Toast.makeText(getApplicationContext(), "Araç Tamamlandı.", Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
            }
        });

        btListele = (Button) findViewById(R.id.idBtListele);
        tv1 = (TextView) findViewById(R.id.idTvListe);

        btListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Veritabani db = new Veritabani(getApplicationContext());
                tv1.setText(db.araclariListele());
            }
        });
    }
}
