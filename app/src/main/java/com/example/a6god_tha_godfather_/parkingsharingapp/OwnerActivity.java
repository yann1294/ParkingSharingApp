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
        private EditText getParkingRegistraion;
        private EditText getOWnerPassword;
        private Button   signUp;

        DatabaseReference databaseOwners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        databaseOwners = FirebaseDatabase.getInstance().getReference("owners");

        getOwnerName = (EditText) findViewById(R.id.edit_name_owner);
        getOwnerMail = (EditText) findViewById(R.id.edit_mail_owner);
        getParkingRegistraion = (EditText) findViewById(R.id.edit_garage_rg);
        getOWnerPassword = (EditText) findViewById(R.id.edit_pwd_owner);
        signUp = (Button)  findViewById(R.id.button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ownerSigningUp();
            }
        });
    }

    public void ownerSigningUp(){

        String name =  getOwnerName.getText().toString().trim();
        String mail = getOwnerMail.getText().toString().trim();
        String parkingReg = getParkingRegistraion.getText().toString().trim();
        String passwd = getOWnerPassword.getText().toString().trim();

            if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(mail)&&!TextUtils.isEmpty(parkingReg)&&!TextUtils.isEmpty(passwd)){

                String id = databaseOwners.push().getKey();

                Owner owner = new Owner(id,name,mail,parkingReg,passwd);

                    databaseOwners.child(id).setValue(owner);
                    databaseOwners.child("name").setValue(name);
                    databaseOwners.child("mail").setValue(mail);
                    databaseOwners.child("parkingReg").setValue(parkingReg);
                    databaseOwners.child("password").setValue(passwd);

                Toast.makeText(this, "Owner added", Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"You should fill the fields",Toast.LENGTH_LONG).show();
            }
    }
}
