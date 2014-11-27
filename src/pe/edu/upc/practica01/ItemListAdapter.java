package pe.edu.upc.practica01;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import pe.edu.upc.practica01.entity.Cliente;

import java.util.List;

public class ItemListAdapter extends BaseAdapter {

    private Activity activity;
    private List<Cliente> listItems;

    public ItemListAdapter(Activity activity) {
        this.activity = activity;
    }

    public ItemListAdapter(Activity activity, List<Cliente> listItems){
        this.activity = activity;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemList lstItem = new ItemList(activity, listItems.get(position) );
        return lstItem;
    }
}
