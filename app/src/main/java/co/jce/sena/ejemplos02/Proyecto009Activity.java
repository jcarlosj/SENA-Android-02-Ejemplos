package co.jce.sena.ejemplos02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by jce on 10/08/15.
 */
public class Proyecto009Activity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate( savedInstanceState );
        setContentView( R .layout .activity_proyecto009 );
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
            Toast .makeText( Proyecto009Activity.this, "Presionó Crear", Toast .LENGTH_SHORT ) .show();
            return true;
        }
        if (id == R.id.action_editar) {
            Toast .makeText( Proyecto009Activity.this, "Presionó Editar", Toast .LENGTH_SHORT ) .show();
            return true;
        }
        if (id == R.id.action_eliminar) {
            Toast .makeText( Proyecto009Activity.this, "Presionó Eliminar", Toast .LENGTH_SHORT ) .show();
            return true;
        }
        if (id == R.id.action_buscar) {
            Toast .makeText( Proyecto009Activity.this, "Presionó Buscar", Toast .LENGTH_SHORT ) .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
