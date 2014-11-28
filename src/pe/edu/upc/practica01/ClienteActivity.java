package pe.edu.upc.practica01;

import pe.edu.upc.practica01.entity.Cliente;
import android.os.Bundle;
import android.widget.TextView;

public class ClienteActivity extends GeneralActivity {

	TextView txtNombre, txtAddress, txtPhone, txtField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);     
        
        Cliente cliente = (Cliente) getIntent().getSerializableExtra("cliente");
        txtNombre = (TextView) findViewById(R.id.lblClienteName);
        txtAddress = (TextView) findViewById(R.id.lblClienteAddress);
        txtPhone = (TextView) findViewById(R.id.lblClientePhone);
        txtField = (TextView) findViewById(R.id.lblClienteField);
        
        txtNombre.setText(cliente.getNombreCompleto());
        txtAddress.setText(cliente.getAddress());
        txtPhone.setText(cliente.getPhone());
        txtField.setText(cliente.getField());
    }
}
