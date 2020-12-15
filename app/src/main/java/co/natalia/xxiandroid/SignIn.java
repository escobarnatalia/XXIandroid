/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import co.natalia.xxiandroid.model.AndroidUsers;
/*
 * This class controls the screen where the user Sign In and save the data on the database.
 */
public class SignIn extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private EditText username,email2,pass2,pass2c;
    private Button signinbtn;

    // -------------------------------------
    // Global Assets
    // -------------------------------------
    private FirebaseDatabase db;
    private FirebaseAuth auth;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        db=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();

        username=findViewById(R.id.username);
        email2=findViewById(R.id.email2);
        pass2=findViewById(R.id.pass2);
        pass2c=findViewById(R.id.pass2c);
        signinbtn=findViewById(R.id.signinbtn);

        signinbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signinbtn:

                auth.createUserWithEmailAndPassword(email2.getText().toString(),pass2.getText().toString())
                        .addOnCompleteListener(
                                task->{
                                    if(task.isSuccessful()){
                                        String id = auth.getCurrentUser().getUid();
                                        AndroidUsers androidusers = new AndroidUsers(
                                                id,
                                                username.getText().toString(),
                                                email2.getText().toString(),
                                                pass2.getText().toString(),
                                                pass2c.getText().toString()
                                        );

                                        db.getReference().child("androidUser").child(id).setValue(androidusers).addOnCompleteListener(
                                                taskdb->{
                                                    if(taskdb.isSuccessful() ) {
                                                        Intent i = new Intent(this, Home.class);
                                                        startActivity(i);
                                                        finish();
                                                    }

                                                }
                                        );

                                }else{
                                        Toast.makeText(this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
            break;
        }
    }
}