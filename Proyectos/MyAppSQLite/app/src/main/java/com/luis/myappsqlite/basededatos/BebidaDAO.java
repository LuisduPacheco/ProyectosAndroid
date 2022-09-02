package com.luis.myappsqlite.basededatos;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luis.myappsqlite.complementos.ConstantesSQL;
import com.luis.myappsqlite.complementos.ConsultasDAO;

import java.util.ArrayList;

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
    @Override
    public Cursor buscarIdBebida(BebidaVO bvo, Context context) {
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
        //A. Declara el objeto que nos permitirá leer la información
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();

        //D. Crear el objeto tipo cursor, permite solicitar información a la BD y luego leerla y obtenerla
        Cursor cursor = null;

        //B Declarar el arreglo y asignarle el codigo de la bebida
        String [] parametro = {bvo.getCodigoBebida().toString()}; //Este arreglo permite identificar un parametro para consultar
        try { //C Crear la consulta
            String consula = "SELECT "+ConstantesSQL.CAMPO_CODIGO+", "+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_SABOR+", "
                                        +ConstantesSQL.CAMPO_PRESENTACION+", "+ConstantesSQL.CAMPO_TIPO+", "+ConstantesSQL.CAMPO_PRECIO+
                                        " FROM "+ConstantesSQL.TBL_BEBIDA +" WHERE "+ConstantesSQL.CAMPO_CODIGO+" = ?";
                                        /*El simbolo ? sirve para parametrizar las consultas, identifica que la primera posición del Arreglo parametro es
                                        lo que se va a trasladar al signo de pregunta*/
            //D.1 - Asignarle un valor al bojeto tipo cursor
            cursor = database.rawQuery(consula, parametro);
            cursor.moveToFirst(); //Trae la información principal
            bvo.setCodigoBebida(cursor.getInt(0));
            bvo.setNombreBebida(cursor.getString(1));
            bvo.setSaborBebida(cursor.getString(2));
            bvo.setPresentacionBebida(cursor.getInt(3));
            bvo.setTipoBebida(cursor.getString(4));
            bvo.setPrecioBebida(cursor.getDouble(5));
            cursor.close();

        }catch (Exception e){
            e.getMessage();
            cursor.close();
            database.close();
        }
        return cursor;
    }

    @Override
    public ArrayList<BebidaVO> listarBebida(BebidaVO bvo, Context context) {
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        ArrayList<BebidaVO> listadoBebidas = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM "+ConstantesSQL.TBL_BEBIDA;
            Cursor cursor = database.rawQuery(consulta, null);
            while (cursor.moveToNext()){
                bvo = new BebidaVO(); //Por cada vuelta se inicia el constructor y se agrega un nuevo elemento
                bvo.setCodigoBebida(cursor.getInt(0));
                bvo.setNombreBebida(cursor.getString(1));
                bvo.setSaborBebida(cursor.getString(2));
                bvo.setPresentacionBebida(cursor.getInt(3));
                bvo.setTipoBebida(cursor.getString(4));
                bvo.setPrecioBebida(cursor.getDouble(5));
                listadoBebidas.add(bvo);
            }
            cursor.close();
        }catch (Exception e){
            e.getMessage();
            database.close();
        }
        return listadoBebidas;
    }

    @Override
    public boolean actualizarBebida(BebidaVO bvo, Context context) {
        boolean resultado = false;
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getWritableDatabase();
        try{
            String consulta = "UPDATE "+ConstantesSQL.TBL_BEBIDA+" SET "+ConstantesSQL.CAMPO_NOMBRE+"= '"+bvo.getNombreBebida()+"', "+
                                        ConstantesSQL.CAMPO_SABOR+"= '"+bvo.getSaborBebida()+"', "+
                                        ConstantesSQL.CAMPO_PRESENTACION+"= "+bvo.getPresentacionBebida()+", "+
                                        ConstantesSQL.CAMPO_TIPO+"= '"+bvo.getTipoBebida()+"', "+
                                        ConstantesSQL.CAMPO_PRECIO+"= "+bvo.getPrecioBebida()+
                                        " WHERE "+ConstantesSQL.CAMPO_CODIGO+" = "+bvo.getCodigoBebida();
            database.execSQL(consulta);
            database.close();
            resultado = true;
        }catch (Exception e){
            e.getMessage();
            database.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarBebida(BebidaVO bvo, Context context) {
        boolean resultado = false;
        ConectorSQLite conectorSQLite = new ConectorSQLite(context, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getWritableDatabase();
        try {
            String consulta = "DELETE FROM "+ConstantesSQL.TBL_BEBIDA+
                            " WHERE "+ConstantesSQL.CAMPO_CODIGO+" = "+bvo.getCodigoBebida();
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







