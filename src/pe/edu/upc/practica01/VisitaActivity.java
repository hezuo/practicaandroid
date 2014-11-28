package pe.edu.upc.practica01;

import java.util.List;

import pe.edu.upc.practica01.controller.MainController;
import pe.edu.upc.practica01.entity.Cliente;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class VisitaActivity extends GeneralActivity implements OnItemClickListener {

    ListView listView;
    ItemListAdapter adapter;
    List<Cliente> listClientes;
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);        
        listView = (ListView) findViewById(R.id.list_view);
        listView.setVisibility(View.GONE);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
        List<Cliente> lista = MainController.getInstance().lstClientes;
        Log.d("Test", "tamaño lista "+ lista.size());
        
        adapter = new ItemListAdapter(VisitaActivity.this, R.layout.activity_item,lista);
        listView.setAdapter(adapter);
        listView.setVisibility(View.VISIBLE);
        listView.setOnItemClickListener(VisitaActivity.this);
        
        inputSearch.addTextChangedListener(new TextWatcher() {
            
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
            	Log.d("Test", "secuencia busqueda"+ cs.toString());
            	VisitaActivity.this.adapter.getFilter().filter(cs);   
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
                 
            }
             
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                          
            }
        });
    
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Cliente bp = (Cliente) parent.getItemAtPosition(position);
		String tel = bp.getAddress();
		
		Toast.makeText(this, tel, Toast.LENGTH_SHORT).show();
		
		 Intent i1 = new Intent(VisitaActivity.this, ClienteActivity.class);		 
         i1.putExtra("cliente", bp);
         startActivity(i1);
		
	}
}
