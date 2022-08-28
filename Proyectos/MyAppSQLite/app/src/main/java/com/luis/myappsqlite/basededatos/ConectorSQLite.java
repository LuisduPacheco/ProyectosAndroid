package com.luis.myappsqlite.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.luis.myappsqlite.complementos.ConstantesSQL;

public class ConectorSQLite extends SQLiteOpenHelper {

    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREAR LA TABLA - A)
        db.execSQL(ConstantesSQL.CREAR_TBL_BEBIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //BORRAR LA TABLA si ya existe - B)
        db.execSQL(ConstantesSQL.BORRAR_TBL_BEBIDA);
        onCreate(db);
    }
}
