package co.jce.sena.ejemplos02;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jce on 10/08/15.
 */
public class Proyecto009Activity extends AppCompatActivity {

    //-> Atributos (Campos)
    private EditText cCedula,
                     cNombres,
                     cColegio,
                     cNroMesa;

    //-> Atributos (Variables)
    private String vCedula,
                   vNombres,
                   vColegio,
                   vNroMesa,
                   vNroCedulaBuscar;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate( savedInstanceState );
        setContentView( R.layout .activity_proyecto009 );

        //-> Busca para acceder a cada campo del "Activity" haciendo un TypeCast según corresponda.
        cCedula = ( EditText ) findViewById( R .id .et_Cedula );
        cNombres = ( EditText ) findViewById( R .id .et_NombresApellidos );
        cColegio = ( EditText ) findViewById( R .id .et_NombreColegio );
        cNroMesa = ( EditText ) findViewById( R .id .et_NumeroMesa );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proyecto009, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_crear) {
            insertar( null );
            return true;
        }
        if (id == R.id.action_editar) {
            editar( null );
            return true;
        }
        if (id == R.id.action_eliminar) {
            eliminar( null );
            return true;
        }
        if (id == R.id.action_buscar) {
            consultar( null );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void capturarCampos() {

        vCedula = cCedula .getText() .toString();
        vNombres = cNombres .getText() .toString();
        vColegio = cColegio .getText() .toString();
        vNroMesa = cNroMesa .getText() .toString();

    }

    private void prepararRegistro( ContentValues registro, String metodo ) {

        if( metodo .equals( "insertar" ) ) {
            registro .put( "cedula", vCedula );
        }
        registro .put( "nombre", vNombres ) ;
        registro .put( "colegio", vColegio );
        registro .put( "nromesa", vNroMesa );

    }

    private void limpiarCampos() {
        cCedula .setText("");
        cNombres .setText("");
        cColegio .setText("");
        cNroMesa .setText("");
    }

    private void insertar( View v ) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this, "administracion", null, 1 );
        SQLiteDatabase db  = admin .getWritableDatabase();

            capturarCampos();
        ContentValues register = new ContentValues();

            prepararRegistro( register, "insertar" );
        db .insert( "volantes", null, register );
        db .close();
        limpiarCampos();
        Toast .makeText( this, "Registro exitoso", Toast .LENGTH_SHORT ) .show();

    }

    private void consultar( View v ) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this, "administracion", null, 1 );
        SQLiteDatabase db  = admin .getWritableDatabase();

        //-> Capturamos el valor (Número de la cédula) que usaremos para buscar si existe un registro.
        vNroCedulaBuscar = cCedula .getText() .toString();

        Cursor row = db .rawQuery( "select nombre, colegio, nromesa from volantes where cedula=" + vNroCedulaBuscar, null );
        if( row .moveToFirst() ) {
            cNombres .setText( row .getString( 0 ) );
            cColegio .setText( row .getString( 1 ) );
            cNroMesa .setText( row .getString( 2 ) );
            Toast .makeText( this, "El registro encontrado.", Toast .LENGTH_SHORT ) .show();
        }
        else {
            Toast .makeText( this, "El registro solicitado no existe.", Toast .LENGTH_SHORT ) .show();
        }
        db .close();
        vNroCedulaBuscar = "";

    }

    private void eliminar( View v ) {

        int cantidadRegistros;
        String mensaje;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this, "administracion", null, 1 );
        SQLiteDatabase db  = admin .getWritableDatabase();

        //-> Capturamos el valor (Número de la cédula) que usaremos para buscar si existe un registro.
        vNroCedulaBuscar = cCedula .getText() .toString();

        cantidadRegistros = db .delete( "volantes", "cedula = " + vNroCedulaBuscar, null );
        db .close();
        limpiarCampos();

        if( cantidadRegistros == 1 ) {
            mensaje = "Registro eliminado.";
        }
        else {
            mensaje = "El registro solicitado no existe.";
        }
        Toast.makeText( this, mensaje, Toast.LENGTH_SHORT).show();

        vNroCedulaBuscar = "";

    }

    private void editar( View v ) {

        int cantidadRegistros;
        String mensaje;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this, "administracion", null, 1 );
        SQLiteDatabase db  = admin .getWritableDatabase();

            capturarCampos();
        ContentValues register = new ContentValues();

            prepararRegistro( register, "editar" );

        //-> Capturamos el valor (Número de la cédula) que usaremos para buscar si existe un registro.
        vNroCedulaBuscar = cCedula .getText() .toString();

        cantidadRegistros = db .update( "volantes", register, "cedula=" + vNroCedulaBuscar, null );
        db .close();
        limpiarCampos();

        if( cantidadRegistros == 1 ) {
            mensaje = "Registro modificado.";
        }
        else {
            mensaje = "El registro solicitado no existe.";
        }
        Toast.makeText( this, mensaje, Toast.LENGTH_SHORT).show();

        vNroCedulaBuscar = "";

    }

}
