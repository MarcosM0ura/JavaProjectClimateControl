package com.example.javaproject_climatecontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String BANCO_DADOS_NOME = "climatecontrol";
    private static int BANCO_DADOS_VERSAO = 1;

    public DataBaseHelper(Context context){
        super(context, BANCO_DADOS_NOME, null, BANCO_DADOS_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE equipamentos(_id INTEGER PRIMARY KEY, marca TEXT, tipo TEXT, local TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAnterior, int versaoProxima){

    }



}
