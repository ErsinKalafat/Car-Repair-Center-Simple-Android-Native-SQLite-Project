package com.example.ersinkalafat.tamirhaneprojesi;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Veritabani extends SQLiteOpenHelper {

    private static final int VERITABANI_VERSIYONU = 1;
    private static final String VERITABANI_ISMI = "arabalar_veritabani";

    private static final String TABLO_ISMI = "arabalar";
    private static String ID = "id";
    private static String MARKA = "marka";
    private static String FIYAT = "fiyat";

    public Veritabani(Context context) {
        super(context, VERITABANI_ISMI, null, VERITABANI_VERSIYONU);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLO_OLUSTUR = "CREATE TABLE " + TABLO_ISMI + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MARKA + "TEXT,"
                + FIYAT + "INTEGER" + ")";
        db.execSQL(TABLO_OLUSTUR);
    }

    public void aracEkle(String marka, String fiyat) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MARKA, marka);
        values.put(FIYAT, fiyat);

        db.insert(TABLO_ISMI, null, values);
        db.close();
    }



    public String araclariListele() {
        // TODO Auto-generated method stub

        String[] sutunlar = new String[] { ID, MARKA, FIYAT};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLO_ISMI, sutunlar, null, null, null, null, null);

        String araclariListele = "";

        int idSiraNo = c.getColumnIndex(ID);
        int markaSiraNo = c.getColumnIndex(MARKA);
        int fiyatSiraNo = c.getColumnIndex(FIYAT);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            araclariListele = araclariListele + c.getString(idSiraNo) + "    "
                     + c.getString(markaSiraNo)  + " "
                    + c.getString(fiyatSiraNo)  + " "
                    + " \n";
        }

        return araclariListele;
    }


    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }


}