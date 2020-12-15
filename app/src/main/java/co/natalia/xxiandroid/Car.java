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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.natalia.xxiandroid.model.Product;
import co.natalia.xxiandroid.model.Sale;

/*
 * This class shows the product that the user want buy of the Android nodo.
 */
public class Car extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private String currentbranch,currentid;
    // -------------------------------------
    // XML references
    //-------------------------------------
    private Product product;
    private Button cpurchase,backbtn;
    private EditText address,fname;
    private TextView title,price2,price3,size;
    // -------------------------------------
    // Global Assets
    // -------------------------------------
    private FirebaseDatabase db;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        db = FirebaseDatabase.getInstance();
        currentid = getIntent().getExtras().getString("id");
        cpurchase= findViewById(R.id.cpurchase);
        backbtn=findViewById(R.id.backbtn);
        address=findViewById(R.id.address);
        fname=findViewById(R.id.fname);
        title=findViewById(R.id.title);
        price2=findViewById(R.id.price2);
        price3=findViewById(R.id.price3);
        size=findViewById(R.id.size);


        cpurchase.setOnClickListener(this);
        backbtn.setOnClickListener(this);



    }

    @Override
    protected void onResume() {
        super.onResume();

        db.getReference().child("Current").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {

                        for (DataSnapshot child:data.getChildren()){
                            currentbranch = child.getValue(String.class);
                        }

                        db.getReference().child("products").child(currentbranch).addListenerForSingleValueEvent(
                                new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot data) {



                                        for (DataSnapshot child:data.getChildren()){
                                            Product temp = child.getValue(Product.class);

                                            if(temp.getProductId().equals(currentid)){
                                                product=temp;
                                            }


                                        }

                                        title.setText(product.getName());
                                        size.setText(product.getSize());
                                        price2.setText(product.getPrice());
                                        price3.setText(product.getPrice());


                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                }
                        );


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backbtn:
                Intent i = new Intent(this,Categories.class);
                startActivity(i);
                finish();

                break;

            case R.id.cpurchase:

                if(Integer.parseInt(product.getQuantity())>0){
                  int newq = Integer.parseInt(product.getQuantity())-1;
                  product.setQuantity(""+newq);
                  db.getReference().child("products").child(currentbranch).child(product.getProductId()).setValue(product);
                    DatabaseReference ref = db.getReference().child("sales").push();
                     Sale sale = new Sale(address.getText().toString(),fname.getText().toString(),ref.getKey(),"",product.getProductId(),product.getName(),product.getSize(),product.getPrice());
                     ref.setValue(sale);
                    Toast.makeText(this,"La compra fue EXITOSA!",Toast.LENGTH_SHORT).show();
                    Intent p = new Intent(this, Home.class);
                    startActivity(p);
                    finish();
                }else{
                    Toast.makeText(this,"Este producto esta agotado",Toast.LENGTH_SHORT).show();
                    Intent p = new Intent(this, Home.class);
                    startActivity(p);
                    finish();
                }

                break;



    }
}
}