package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    private Button womanBtn;
    private ImageButton homeBtn;
    private ImageButton profileBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        womanBtn = findViewById(R.id.WomanBtn);
        homeBtn = findViewById(R.id.homeBtn);
        profileBtn = findViewById(R.id.profileBtn);

        womanBtn.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this,Categories.class);
                    startActivity(i);
                    finish();

                }
        );
    }


}