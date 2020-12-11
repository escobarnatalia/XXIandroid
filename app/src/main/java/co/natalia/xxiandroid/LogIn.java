package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        loginbtn=findViewById(R.id.loginbtn);




        loginbtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,Home.class);
                    startActivity(i);
                }


        );

    }
}