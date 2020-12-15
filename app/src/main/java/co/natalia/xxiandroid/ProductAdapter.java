/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.natalia.xxiandroid;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.natalia.xxiandroid.model.Product;

/*
 * This class will represent the product list on the screen.
 */

public class ProductAdapter extends BaseAdapter  {

    // -------------------------------------
    // Atributtes
    // -------------------------------------
    private ArrayList<Product> product;

    // -------------------------------------
    // Methods
    // -------------------------------------
    public ProductAdapter() {product = new ArrayList<>();}

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int i) {
        return product.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product,null);
        TextView name = row.findViewById(R.id.name);
        TextView price = row.findViewById(R.id.price);
        ImageView imageV = row.findViewById(R.id.imageV);

        name.setText(product.get(i).getName());
        price.setText(""+product.get(i).getPrice());

        row.setOnClickListener(
                (v)->{
                    Intent l = new Intent(viewGroup.getContext(),Car.class);
                    l.putExtra("id",product.get(i).getProductId());
                    viewGroup.getContext().startActivity(l);
                    ((Activity)(viewGroup.getContext())).finish();
                }
        );

        return row;
    }

    public void addProduct( Product products){
        product.add(products);
        notifyDataSetChanged();
    }


}
