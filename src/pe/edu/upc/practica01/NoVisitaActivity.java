package pe.edu.upc.practica01;

import pe.edu.upc.practica01.entity.Cliente;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NoVisitaActivity extends GeneralActivity {

	private Button btRegistrarNoVisita;
	TextView txtID, txtNombre;
	Cliente cliente;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_visita);
		
		btRegistrarNoVisita = (Button) findViewById(R.id.buttonRegistrarNovisita);
		
		
		cliente = (Cliente) getIntent().getSerializableExtra("cliente");
		
				
		
		txtID = (TextView) findViewById(R.id.lblClienteID);
		txtNombre = (TextView) findViewById(R.id.lblClienteNombre);
		
		txtID.setText(cliente.getId());
		txtNombre.setText(cliente.getNombreCompleto());
		
        
		
		
		
		btRegistrarNoVisita.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                	cliente = (Cliente) getIntent().getSerializableExtra("cliente");
                	cliente.setEstadoVisita(false);
                	Intent i1 = new Intent(NoVisitaActivity.this, VisitaActivity.class);
                    startActivity(i1);

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }
            }
        });
		
		
        
	}
}
