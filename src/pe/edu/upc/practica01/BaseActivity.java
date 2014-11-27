package pe.edu.upc.practica01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pe.edu.upc.practica01.application.MyApplication;

public class BaseActivity extends GeneralActivity {

    private Button btInicio, btVisita, btFin;
    private MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //app
        app = (MyApplication) getApplication();

        //buttons
        btInicio = (Button) findViewById(R.id.btInicio);
        btVisita = (Button) findViewById(R.id.btVisita);
        btFin = (Button) findViewById(R.id.btFin);

        if (!app.isLoggedIn()) {

            btVisita.setVisibility(View.INVISIBLE);
            btFin.setVisibility(View.INVISIBLE);
        } else {

            btInicio.setVisibility(View.INVISIBLE);
        }

        //inicio
        btInicio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    app.setLoggedIn(true);
                    Toast.makeText(getApplicationContext(), "Ha iniciado el dia. ahora sera redirido al login", Toast.LENGTH_SHORT).show();

                    Intent i1 = new Intent(BaseActivity.this, MainActivity.class);
                    startActivity(i1);

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }
            }
        });

        btVisita.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    Intent i1 = new Intent(BaseActivity.this, VisitaActivity.class);
                    startActivity(i1);

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }
            }
        });

        btFin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    //invocar servicio
                    finish();

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }
            }
        });

    }
}
