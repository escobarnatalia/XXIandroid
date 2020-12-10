package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    private Button signinbtn;
    private EditText username;
    private EditText email2;
    private EditText pass2;
    private EditText pass2c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signinbtn=findViewById(R.id.signinbtn);

        username=findViewById(R.id.username);
        email2=findViewById(R.id.email2);
        pass2=findViewById(R.id.pass2);
        pass2c=findViewById(R.id.pass2c);


        signinbtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,Home.class);
                    startActivity(i);
                }


        );




    }
}