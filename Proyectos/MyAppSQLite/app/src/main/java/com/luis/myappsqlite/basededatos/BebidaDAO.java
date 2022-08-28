package com.luis.myappsqlite.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.luis.myappsqlite.complementos.ConstantesSQL;
import com.luis.myappsqlite.complementos.ConsultasDAO;

public class BebidaDAO implements ConsultasDAO {


    @Override
    public boolean insertarBebida(BebidaVO bvo, Context context) {
        boolean resultado = false;
        //Paso 1 - Implementar el constructor del conector
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
        //Paso 2 - Instanciar un objeto que nos permitirá realizar la acción de escribir o registrar datos
        SQLiteDatabase database = conectorSQLite.getWritableDatabase(); //Permite insertar en la base de datos
        try {
            String consulta = "INSERT INTO "+ConstantesSQL.TBL_BEBIDA +" ("+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_SABOR+","
                                            +ConstantesSQL.CAMPO_PRESENTACION+", "+ConstantesSQL.CAMPO_TIPO+", "+ConstantesSQL.CAMPO_PRECIO+")"+
                                " VALUES ('"+bvo.getNombreBebida()+"', '"+bvo.getSaborBebida()+"', "+bvo.getPresentacionBebida()+", '"
                                            +bvo.getTipoBebida()+"', "+bvo.getPrecioBebida()+")";
            database.execSQL(consulta);
            database.close();
            resultado = true;
        }catch (Exception e){
            e.getMessage();
            database.close();
        }
        return resultado;
    }
}
