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
 * This class shows the Categories with the product available on the data base of the Android nodo.
 */
public class Categories extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private Button profilebtn2,homebtn2,coatbtn,jeanbtn,shoesbtn;

    // -------------------------------------
    // Android methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        profilebtn2=findViewById(R.id.profilebtn2);
        homebtn2=findViewById(R.id.homebtn2);
        coatbtn=findViewById(R.id.coatbtn);
        jeanbtn=findViewById(R.id.jeansbtn);
        shoesbtn=findViewById(R.id.shoesbtn);

        homebtn2.setOnClickListener(this);
        profilebtn2.setOnClickListener(this);
        coatbtn.setOnClickListener(this);
        jeanbtn.setOnClickListener(this);
        shoesbtn.setOnClickListener(this);

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

            case R.id.shoesbtn:
                Intent s = new Intent(this, Shoe.class);
                startActivity(s);
                finish();
                break;

            case R.id.jeansbtn:
                Intent j = new Intent(this, Jean.class);
                startActivity(j);
                finish();
                break;




    }
}

}
