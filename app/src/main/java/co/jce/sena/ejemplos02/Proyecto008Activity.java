package co.jce.sena.ejemplos02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jce on 10/08/15.
 */
public class Proyecto008Activity extends AppCompatActivity {

    //-> Atributos (Componentes)
    private Button cAcercaDe;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate(savedInstanceState);
        setContentView( R .layout .activity_proyecto008 );

        //-> Busca para acceder a cada campo del "Activity" haciendo un TypeCast según corresponda.
        cAcercaDe = ( Button ) findViewById( R .id .btn_AcercaDe );

        // Manejador de Eventos para el botón Cálcular
        cAcercaDe .setOnClickListener( new View .OnClickListener() {
            @Override
            public void onClick( View v ) {
                acercade( null );
            }
        });

    }

    public void acercade( View v ) {
        Intent i = new Intent( this, AcercaDeActivity.class );
        i .putExtra( "autor", "Juan Carlos" );
        startActivity( i );
    }

}
