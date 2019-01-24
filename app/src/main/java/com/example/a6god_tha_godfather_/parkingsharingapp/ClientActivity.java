package com.example.a6god_tha_godfather_.parkingsharingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a6god_tha_godfather_.parkingsharingapp.model.Client;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class ClientActivity extends AppCompatActivity {

   private EditText getClientName;
   private EditText getClientMail;
   private EditText getClientCarModel;
   private EditText getClientPassword ;
   private Button signUp ;
   private Button goToLogin ;

   DatabaseReference databaseClients;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        databaseClients = FirebaseDatabase.getInstance().getReference("clients");

        getClientName = (EditText) findViewById(R.id.edit_name) ;
        getClientMail = (EditText) findViewById(R.id.edit_mail_sUp) ;
        getClientCarModel = (EditText) findViewById(R.id.edit_car_model) ;
        getClientPassword = (EditText) findViewById(R.id.edit_pwd_client) ;
        signUp = (Button)  findViewById(R.id.btn_sUp_client) ;


            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clientSigningUP();
                }
            });
    }

    public void clientSigningUP() {

        String name =  getClientName.getText().toString().trim();
        String mail = getClientMail.getText().toString().trim();
        String carModel = getClientCarModel.getText().toString().trim();
        String passwd = getClientPassword.getText().toString().trim();

            if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(mail)&&!TextUtils.isEmpty(carModel)&&!TextUtils.isEmpty(passwd)){

               String id = databaseClients.push().getKey();

                Client client = new Client(id,name,mail,carModel,passwd);

                databaseClients.child(id).setValue(client);
                databaseClients.child("Name").setValue(name);
                databaseClients.child("mail").setValue(mail);
                databaseClients.child("carModel").setValue(carModel);
                databaseClients.child("passwd").setValue(passwd);

                Toast.makeText(this, "Client added", Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(this,"You should fill the fields",Toast.LENGTH_LONG).show();
            }
    }


    public void goToLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
