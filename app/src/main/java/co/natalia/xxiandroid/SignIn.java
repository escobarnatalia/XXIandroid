package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private EditText username,email2,pass2,pass2c;
    private Button signinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        db=FirebaseDatabase.getInstance();

        username=findViewById(R.id.username);
        email2=findViewById(R.id.email2);
        pass2=findViewById(R.id.pass2);
        pass2c=findViewById(R.id.pass2c);
        signinbtn=findViewById(R.id.signinbtn);

        signinbtn.setOnClickListener(this);

                    /*Intent i = new Intent(this,Home.class);
                    startActivity(i);*/





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signinbtn:
                String id= db.getReference().child("androidUser").push().getKey();
                DatabaseReference reference =db.getReference().child("androidUser").child(id);
                AndroidUsers androidusers = new AndroidUsers(
                        id,
                        username.getText().toString(),
                        email2.getText().toString(),
                        pass2.getText().toString(),
                        pass2c.getText().toString()
                );

                reference.setValue(androidusers);


                break;



        }
    }
}