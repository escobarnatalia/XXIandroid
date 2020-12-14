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

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText pass;
    private Button loginbtn;
    private FirebaseAuth auth;

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