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
import android.widget.Button;
import android.widget.ImageButton;

/*
 * This class shows the principal menu, the user can see this screen after log in of the Android node.
 */
public class Home extends AppCompatActivity {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private Button womanbtn;
    private Button profilebtn2;

    // -------------------------------------
    // Android methods
    // -------------------------------------
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
                    finish();
                }
        );
    }


}