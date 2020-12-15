/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.natalia.xxiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * This class controls the screen where the user decide Sing In or Log In.
 */
public class LogSign extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private Button logbwbtn;
    private Button signbwbtn;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign);

        logbwbtn = findViewById(R.id.logbwbtn);
        signbwbtn = findViewById(R.id.signbwbtn);


        logbwbtn.setOnClickListener(this);
        signbwbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signbwbtn:
                Intent i = new Intent(this, SignIn.class);
                startActivity(i);
                finish();
                break;


            case R.id.logbwbtn:
                Intent l = new Intent(this, LogIn.class);
                startActivity(l);
                finish();

                break;
        }
    }


}