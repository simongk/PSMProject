package com.example.simongk.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by simongk on 18.06.16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String dbName="baza";
    static final String zajeciaTable = "Zajecia";
    static final String colId = "ZajeciaID";
    static final String colNazwa = "ZajeciaNazwa";

    public DatabaseHelper(Context context) {
        super(context, dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+zajeciaTable+"("+colId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
        colNazwa+" TEXT");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
