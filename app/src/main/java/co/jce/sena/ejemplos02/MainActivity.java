package co.jce.sena.ejemplos02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //-> Atributos (Componentes)
    private Button cProyecto008, cProyecto009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-> Acceder a los componentes del "Activity" a través de la "Clase R" haciendo un TypeCast según corresponda.
        cProyecto008 = ( Button ) findViewById( R .id .btn_Proyecto008 );
        cProyecto009 = ( Button ) findViewById( R .id .btn_Proyecto009 );

        // Manejador de Eventos para el botón "Proyecto008"
        cProyecto008 .setOnClickListener( new View .OnClickListener() {
            @Override
            public void onClick(View v) {
                proyecto008( null );
            }
        });

        // Manejador de Eventos para el botón "Proyecto009"
        cProyecto009 .setOnClickListener( new View .OnClickListener() {
            @Override
            public void onClick(View v) {
                proyecto009( null );
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void proyecto008( View v ) {

        Intent i = new Intent( this, Proyecto008Activity.class );
        startActivity(i);

    }

    public void proyecto009( View v ) {

        Intent i = new Intent( this, Proyecto009Activity.class );
        startActivity( i );

    }

}
