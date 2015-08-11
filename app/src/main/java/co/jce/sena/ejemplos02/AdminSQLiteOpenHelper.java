package co.jce.sena.ejemplos02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jce on 10/08/15.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //-> Constructor
    public AdminSQLiteOpenHelper( Context context, String name, SQLiteDatabase .CursorFactory factory, int version ) {
        super( context, name, factory, version );
    }

    @Override
    public void onCreate( SQLiteDatabase db ) {
        db .execSQL( "create table volantes( cedula integer primary key, nombre text, colegio text, nromesa integer );" );
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db .execSQL( "droptable if exists volantes; " +
                     "create table volantes( cedula integer primary key, nombre text, colegio text, nromesa integer );" );
    }
}
