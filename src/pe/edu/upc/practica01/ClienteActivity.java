package pe.edu.upc.practica01;

import pe.edu.upc.practica01.entity.Cliente;
import android.os.Bundle;
import android.widget.EditText;

public class ClienteActivity extends GeneralActivity {

	EditText txtNombre, txtAddress, txtPhone, txtField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);     
        
        Cliente cliente = (Cliente) getIntent().getSerializableExtra("cliente");
        txtNombre = (EditText) findViewById(R.id.lblClienteName);
        txtAddress = (EditText) findViewById(R.id.lblClienteAddress);
        txtPhone = (EditText) findViewById(R.id.lblClientePhone);
        txtField = (EditText) findViewById(R.id.lblClienteField);
        
        txtNombre.setText(cliente.getNombreCompleto());
        txtAddress.setText(cliente.getAddress());
        txtPhone.setText(cliente.getPhone());
        txtField.setText(cliente.getField());
    }
}
