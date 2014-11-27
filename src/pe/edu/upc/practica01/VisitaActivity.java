package pe.edu.upc.practica01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import pe.edu.upc.practica01.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class VisitaActivity extends GeneralActivity {

    private ListView listView;
    private ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setName("Cesar Pillihuaman");


        List<Cliente> listClientes = new ArrayList<Cliente>();
        listClientes.add(cliente);

        adapter = new ItemListAdapter(this, listClientes);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                try {

                    Intent i1 = new Intent(VisitaActivity.this, ClienteActivity.class);
                    i1.putExtra("selectedChapter", position);
                    startActivity(i1);

                } catch (Exception e) {
                    Log.e(getPackageName(), e.getMessage());
                }

            }
        });

    }
}
