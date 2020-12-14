package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    private Button womanbtn;
    private Button profilebtn2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        womanbtn = findViewById(R.id.womanbtn);
        profilebtn2 = findViewById(R.id.profilebtn2);


        womanbtn.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this,Categories.class);
                    startActivity(i);
                    finish();
                }
        );

        profilebtn2.setOnClickListener(
                (v) -> {
                    Intent p = new Intent(this, Profile.class);
                    startActivity(p);
                }
        );
    }


}