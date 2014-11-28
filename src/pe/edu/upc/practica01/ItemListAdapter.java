package pe.edu.upc.practica01;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.practica01.entity.Cliente;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemListAdapter extends ArrayAdapter<Cliente> implements Filterable{

	Context context;
	List<Cliente> items;
	List<Cliente> filteredData;
	int resource;
	
     List<Cliente> listItems;

    public ItemListAdapter(Context context, int resource,
			List<Cliente> items) {
    	super(context, resource, items);
    	this.context = context;
		this.items = items;
		this.filteredData = items;
		this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
    	LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    	Cliente item = filteredData.get(position);
		LinearLayout nuevaVista;
		
		if (convertView == null) {
			nuevaVista = new LinearLayout(getContext());
			inflater.inflate(resource, nuevaVista, true);
		} else {
			nuevaVista = (LinearLayout) convertView;
		}

		TextView txtNombre = (TextView) nuevaVista.findViewById(R.id.lblName);
		TextView txtAddress = (TextView) nuevaVista.findViewById(R.id.lblAddress);
		
		if (txtNombre != null) {
			txtNombre.setText(item.getNombreCompleto());
		}
		if(txtAddress != null){
			txtAddress.setText(item.getAddress());
		}
		
        return nuevaVista;
    }
	@Override
    public Filter getFilter() {
       return myFilter;
   }
	
	//For this helper method, return based on filteredData
    public int getCount() 
    {
        return filteredData.size();
    }

    //This should return a data object, not an int
    public Cliente getItem(int position) 
    {
        return filteredData.get(position);
    }
    
    public long getItemId(int position) 
    {
        return position;
    }
	
	Filter myFilter = new Filter() { 
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
         FilterResults filterResults = new FilterResults();   
         List<Cliente> tempList=new ArrayList<Cliente>();
         //constraint is the result from text you want to filter against. 
         //objects is your data set you will filter from
         if(constraint != null && items!=null) {
             int length=items.size();
             Log.d("Test", "total clientes: "+ length);
             int i=0;
                while(i<length){
                	Cliente item=items.get(i);
                	Log.d("Test", "cliente: "+ item.getNombreCompleto());
                	Log.d("Test", constraint.toString().toLowerCase() + (item.getNombreCompleto().toLowerCase().contains(constraint.toString().toLowerCase())));
                	if (item.getNombreCompleto().toLowerCase().contains(constraint.toString().toLowerCase())){
                		Log.d("Test", "cliente ENCONTRADO: "+ item.getNombreCompleto());
                		tempList.add(item);	
                	}
                    i++;
                }
                //following two lines is very important
                //as publish result can only take FilterResults objects
                filterResults.values = tempList;
                filterResults.count = tempList.size();
          }
          return filterResults;
      }

      @SuppressWarnings("unchecked")
      @Override
      protected void publishResults(CharSequence contraint, FilterResults results) {
    	  filteredData = (ArrayList<Cliente>) results.values;
          if (results.count > 0) {
        	  notifyDataSetChanged();
          } else {
              notifyDataSetInvalidated();
          }  
      }
     };
}
