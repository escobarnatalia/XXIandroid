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
/*
 * This class controls the Splash screen.
 */
public class MainActivity extends AppCompatActivity {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private Button next;

    // -------------------------------------
    // Android methods
    // -------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=findViewById(R.id.next);

        next.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this,LogSign.class);
                    startActivity(i);

                }
        );
    }
}