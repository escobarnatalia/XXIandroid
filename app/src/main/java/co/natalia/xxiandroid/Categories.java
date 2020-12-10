package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class Categories extends AppCompatActivity {

    private ImageButton shoesBtn;
    private ImageButton jeansBtn;
    private ImageButton coatsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        shoesBtn = findViewById(R.id.shoesBtn);
        jeansBtn = findViewById(R.id.jeansBtn);
        coatsBtn = findViewById(R.id.coatsBtn);

    }
}