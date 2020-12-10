package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LogSign extends AppCompatActivity {

    private Button logbwbtn;
    private Button signbwbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign);

        logbwbtn =findViewById(R.id.logbwbtn);
        signbwbtn=findViewById(R.id.signbwbtn);



        logbwbtn.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this,LogIn.class);
                    startActivity(i);

                }


        );

        signbwbtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,SignIn.class);
                    startActivity(i);
                }


        );



    }
}