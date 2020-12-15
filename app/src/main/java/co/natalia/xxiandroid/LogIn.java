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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
/*
 * This class controls the screen where the user Log In with the data saved database.
 */
public class LogIn extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private EditText email;
    private EditText pass;
    private Button loginbtn;

    // -------------------------------------
    // Global Assets
    // -------------------------------------
    private FirebaseAuth auth;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        loginbtn=findViewById(R.id.loginbtn);

        auth=FirebaseAuth.getInstance();

        /*Intent i = new Intent(this,Home.class);
        startActivity(i);*/
        loginbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.loginbtn:
    auth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(
            task->{
                if(task.isSuccessful()){
                    Intent i = new Intent(this,Home.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }


    );
                break;
        }

    }
}