package pe.edu.upc.practica01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends GeneralActivity {

    private Button btLogin;
    private TextView txtName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.txtName);
        txtPassword = (TextView) findViewById(R.id.txtPassword);


        //button
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    Intent i1 = new Intent(MainActivity.this, BaseActivity.class);
                    startActivity(i1);

                    if (txtName.getText()=="user" && txtPassword.getText()=="pass" ) {
                        // validar login aqui

                    }

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }
            }
        });

    }

}
