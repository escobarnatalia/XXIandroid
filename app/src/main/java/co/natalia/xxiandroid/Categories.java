package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Categories extends AppCompatActivity implements View.OnClickListener {

    private Button profilebtn2,homebtn2,coatbtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        profilebtn2=findViewById(R.id.profilebtn2);
        homebtn2=findViewById(R.id.homebtn2);
        coatbtn=findViewById(R.id.coatbtn);

        homebtn2.setOnClickListener(this);
        profilebtn2.setOnClickListener(this);
        coatbtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homebtn2:
                Intent p = new Intent(this, Home.class);
                startActivity(p);
                finish();

                break;

            case R.id.profilebtn2:
                Intent i = new Intent(this, Profile.class);
                startActivity(i);
                finish();
                break;

            case R.id.coatbtn:
                Intent l = new Intent(this, Coat.class);
                startActivity(l);
                finish();
                break;



    }
}

}
