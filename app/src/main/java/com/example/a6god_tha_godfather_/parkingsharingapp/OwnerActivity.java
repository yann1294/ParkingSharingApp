package com.example.a6god_tha_godfather_.parkingsharingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a6god_tha_godfather_.parkingsharingapp.model.Owner;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class OwnerActivity extends AppCompatActivity {

    private EditText getOwnerName;
    private EditText getOwnerMail;
    private EditText getOWnerPassword;
    private Button signUp;

    DatabaseReference databaseOwners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        databaseOwners = FirebaseDatabase.getInstance().getReference("owners");

        getOwnerName = (EditText) findViewById(R.id.name);
        getOwnerMail = (EditText) findViewById(R.id.email);
        getOWnerPassword = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.btnRegister);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ownerSigningUp();
            }
        });
    }

    public void ownerSigningUp() {

        String name = getOwnerName.getText().toString().trim();
        String mail = getOwnerMail.getText().toString().trim();
        String passwd = getOWnerPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(mail) && !TextUtils.isEmpty(passwd)) {

            String id = databaseOwners.push().getKey();

            Owner owner = new Owner(id, name, mail, passwd);

            databaseOwners.child(id).setValue(owner);
            databaseOwners.child("name").setValue(name);
            databaseOwners.child("mail").setValue(mail);
            databaseOwners.child("password").setValue(passwd);

            Toast.makeText(this, "Owner added", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You should fill the fields", Toast.LENGTH_LONG).show();
        }
    }
}
