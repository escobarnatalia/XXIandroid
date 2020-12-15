package co.natalia.xxiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Car extends AppCompatActivity implements View.OnClickListener {

    private String currentbranch,currentid;
    private FirebaseDatabase db;
    private Product product;
    private Button cpurchase,backarrow;
    private EditText address,fname;
    private TextView Title,price2,size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        db = FirebaseDatabase.getInstance();
        currentid = getIntent().getExtras().getString("id");
        cpurchase= findViewById(R.id.cpurchase);
        backarrow=findViewById(R.id.backarrow);
        address=findViewById(R.id.address);
        fname=findViewById(R.id.fname);
        Title=findViewById(R.id.Title);
        price2=findViewById(R.id.price2);
        size=findViewById(R.id.size);


        cpurchase.setOnClickListener(this);



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

                                        Title.setText(product.getName());
                                        size.setText(product.getSize());
                                        price2.setText(product.getPrice());


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

            case R.id.backarrow:
                Intent l = new Intent(this,Coat.class);
                startActivity(l);
                finish();

                break;

    }
}
}