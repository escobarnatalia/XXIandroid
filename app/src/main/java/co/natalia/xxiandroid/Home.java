package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    private Button womanbtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        womanbtn = findViewById(R.id.womanbtn);


        womanbtn.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this,Categories.class);
                    startActivity(i);


                }
        );
    }


}