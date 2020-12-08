package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LogSign extends AppCompatActivity {

    private Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign);

        next2=findViewById(R.id.next2);



        next2.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this,Home.class);
                    startActivity(i);

                }


        );



    }
}