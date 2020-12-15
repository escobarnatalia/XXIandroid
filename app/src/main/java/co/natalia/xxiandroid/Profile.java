/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @authors  Wilson Suarez, Natalia Escobar, Nicolás Penagos, Valentina Zapata
 * wilsonst.suarez@hotmail.com
 * nataliaescfer@gmail.com
 * nicolas.penagosm98@gmail.com
 * valentinazapataz0306@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.natalia.xxiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.natalia.xxiandroid.model.AndroidUsers;
/*
 * This class shows the profile of the user with de data saved database.
 */
public class Profile extends AppCompatActivity implements View.OnClickListener {

    // -------------------------------------
    // XML references
    //-------------------------------------
    private TextView usernameTx;
    private Button SignOffBtn;
    private Button homebtn2;
    // -------------------------------------
    // Global Assets
    // -------------------------------------
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    // -------------------------------------
    // XML references
    // -------------------------------------
    private AndroidUsers users;

    // -------------------------------------
    // Android methods
    // -------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameTx = findViewById(R.id.usernameTx);
        SignOffBtn = findViewById(R.id.SignOffBtn);
        homebtn2 = findViewById(R.id.homebtn2);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        SignOffBtn.setOnClickListener(this);
        homebtn2.setOnClickListener(this);


        recoverUser();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.SignOffBtn:
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("Cerrar sesión")
                        .setMessage("¿Esta seguro que desea cerrar sesión?")
                        .setNegativeButton("NO", (dialog,id) ->{
                            dialog.dismiss();
                        })
                        .setPositiveButton("SI", (dialog, id) ->{
                            auth.signOut();
                            finish();
                        });
                        builder.show();
                break;

            case R.id.homebtn2:
                Intent p = new Intent(this, Home.class);
                startActivity(p);
                finish();

                break;


        }
    }

    // -------------------------------------
    // Methods
    // -------------------------------------
    private void recoverUser() {
        if (auth.getCurrentUser() != null){
            String id = auth.getCurrentUser().getUid();
            db.getReference().child("androidUser").child(id).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            users = snapshot.getValue(AndroidUsers.class);
                            usernameTx.setText(users.getUsername());

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    }
            );


        }
    }
}