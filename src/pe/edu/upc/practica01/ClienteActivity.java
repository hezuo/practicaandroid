package pe.edu.upc.practica01;

import pe.edu.upc.practica01.entity.Cliente;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClienteActivity extends GeneralActivity {

	TextView txtNombre, txtAddress, txtPhone, txtField;
	private Button btNoVisita, btVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);   
        
        btNoVisita = (Button) findViewById(R.id.buttonNoVisita);
        btVisita = (Button) findViewById(R.id.buttonRegistrarNovisita);
        
        Cliente cliente = (Cliente) getIntent().getSerializableExtra("cliente");
        txtNombre = (TextView) findViewById(R.id.lblClienteName);
        txtAddress = (TextView) findViewById(R.id.lblClienteAddress);
        txtPhone = (TextView) findViewById(R.id.lblClientePhone);
        txtField = (TextView) findViewById(R.id.lblClienteField);
        
        
        
        txtNombre.setText(cliente.getNombreCompleto());
        txtAddress.setText(cliente.getAddress());
        txtPhone.setText(cliente.getPhone());
        txtField.setText(cliente.getField());
        
        boolean  opcion = cliente.getEstadoVisita();
        
        
        if (opcion) {
        	btNoVisita.setVisibility(View.VISIBLE);
        	btVisita.setVisibility(View.VISIBLE);
        } else {
        	
        	btNoVisita.setVisibility(View.INVISIBLE);
        	btVisita.setVisibility(View.INVISIBLE);
        }
        
        
        
        btNoVisita.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {
                	
                	Cliente bp = (Cliente) getIntent().getSerializableExtra("cliente");
                	          	
                    Intent i1 = new Intent(ClienteActivity.this, NoVisitaActivity.class);
                    i1.putExtra("cliente", bp);
                    startActivity(i1);

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }
            }
        });
        
    }
}
