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

public class Coat extends AppCompatActivity implements View.OnClickListener {

    private GridView productList;
    private ProductAdapter adapter;
    private Button profilebtn2, homebtn2;
    private FirebaseDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coat);

        db = FirebaseDatabase.getInstance();

        productList = findViewById(R.id.productList);
        adapter = new ProductAdapter();
        productList.setAdapter(adapter);

        profilebtn2 = findViewById(R.id.profilebtn2);
        homebtn2 = findViewById(R.id.homebtn2);

        homebtn2.setOnClickListener(this);
        profilebtn2.setOnClickListener(this);

        db.getReference().child("products").child("coats").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {

                        for (DataSnapshot child:data.getChildren()){

                           /* Object o = data.getValue(Object.class);
                            if(o instanceof Product){
                                Log.e("debug","no es product");
                            }*/

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
        db.getReference().child("Current").child("branch").setValue("coats");


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