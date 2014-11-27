package pe.edu.upc.practica01;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import pe.edu.upc.practica01.entity.Cliente;

public class ItemList extends LinearLayout {

    private TextView lblName,lblAddress;
    private Cliente cliente;

    public ItemList(Context context, Cliente cliente) {
        super(context);
        this.cliente = cliente;
        start();
    }

    private void start() {

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);

        li.inflate(R.layout.activity_item, this, true);

        lblName = (TextView) findViewById(R.id.lblName);
        lblAddress = (TextView) findViewById(R.id.lblAddress);
        lblName.setText( cliente.getName() + " " + cliente.getLastName() );
        lblAddress.setText(cliente.getAddress());

    }
}
