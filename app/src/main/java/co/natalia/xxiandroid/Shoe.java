/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.natalia.xxiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.natalia.xxiandroid.model.Product;

/*
 * This class shows the shoes product available on the data base of the Android nodo.
 */
public class Shoe extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private GridView productList;
    private Button profilebtn2, homebtn2;

    // -------------------------------------
    // Global Assets
    // -------------------------------------
    private FirebaseDatabase db;
    private ProductAdapter adapter;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        db = FirebaseDatabase.getInstance();

        productList = findViewById(R.id.productList);
        adapter = new ProductAdapter();
        productList.setAdapter(adapter);

        profilebtn2 = findViewById(R.id.profilebtn2);
        homebtn2 = findViewById(R.id.homebtn2);

        homebtn2.setOnClickListener(this);
        profilebtn2.setOnClickListener(this);

        db.getReference().child("products").child("shoes").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {

                        for (DataSnapshot child:data.getChildren()){

                            Product product = child.getValue(Product.class);
                            adapter.addProduct(product);


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        db.getReference().child("Current").child("branch").setValue("shoes");


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homebtn2:
                Intent p = new Intent(this, Home.class);
                startActivity(p);
                finish();

                break;

            case R.id.profilebtn2:
                Intent i = new Intent(this, Profile.class);
                startActivity(i);
                finish();
                break;

        }
    }
}