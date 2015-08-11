package co.jce.sena.ejemplos02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jce on 11/08/15.
 */
public class AcercaDeActivity extends Activity {

    //-> Atributos (Variables)
    private TextView cAutor;
    private Button cFinalizar;

    //-> Atributos (Variables)
    private String vAutor;

    //-> Atributos (Especiales)
    private Bundle extras;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout .activity_acercade );

        //-> Busca para acceder a cada campo del "Activity" haciendo un TypeCast según corresponda.
        cAutor = ( TextView ) findViewById( R .id .tv_Autor );
        cFinalizar = ( Button ) findViewById( R .id .btn_Finalizar );

        // Manejador de Eventos para el botón Cálcular
        cFinalizar .setOnClickListener( new View .OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrar(null);
            }
        });

        //-> Obtenemos el valor enviado desde el "Activity" anterior.
        extras = getIntent() .getExtras();
        vAutor = extras .getString( "autor" );
        cAutor .setText( "Autor: " + vAutor );

    }

    public void cerrar( View v ) {
        finish();
    }


}
