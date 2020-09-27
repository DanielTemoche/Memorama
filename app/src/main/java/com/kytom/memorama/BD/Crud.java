package com.kytom.memorama.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;

import java.util.ArrayList;

//esta es la clase crud con extencion a SQLiteOpenHelper  para crear nuestra base de datos y las tablas que necesitamos, junto con los metodos para
// modificar y consultar dichas tablas
public class Crud extends SQLiteOpenHelper {

    public Crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //este es el metodo para crear nuestras tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_tiempo(id integer primary key autoincrement,minutos text,segundos text,siTiempo integer)");
        ContentValues registro =new ContentValues();
        registro.put("nombre","nadie");
        registro.put("puntaje","0");
        registro.put("tiempo","0");
        for (int i=0;i<30;i++){
            db.insert("tb_puntaje",null,registro);
        }
        ContentValues registro1=new ContentValues();
        registro1.put("minutos","0");
        registro1.put("segundos","0");
        registro1.put("siTiempo","0");
        db.insert("tb_tiempo",null,registro1);
    }

    //este es el metodo para verificar si ya existen las tablas, entonces eliminarlas y volverlas a crear
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("drop table if exists tb_tiempo");
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_tiempo(id integer primary key autoincrement,minutos text,segundos text,siTiempo integer)");
    }

    //este es el metodo para inicializar nuestra base de datos, para realizar cualquier operacion
    public void iniciarBD(Context context){
        Crud crud=new Crud(context,"puntaje", null, 1);
        SQLiteDatabase db=crud.getWritableDatabase();
    }

    //en este metodo podemos modificar cualquiera de nuestras tablas
    public void modificar(Context context, String table, ContentValues registro, String id){
        Crud crud=new Crud(context,"puntaje", null, 1);
        SQLiteDatabase db=crud.getWritableDatabase();
        db.update(table,registro,"id="+id,null);
    }
    //este es el metodo para realizar consultas a cualquiera de nuestras tablas
    public void consultar(Context context, String table , ArrayList<PuntajesVo> lista){
        Crud crud=new Crud(context,"puntaje", null, 1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+table,null);
        while (cursor.moveToNext()){
            lista.add(new PuntajesVo(cursor.getString(1),cursor.getString(2),cursor.getString(3)));
        }
        cursor.close();

    }
}
