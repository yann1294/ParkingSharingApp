package com.example.a6god_tha_godfather_.parkingsharingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginBtn;
    private Button signUpBtn;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        email =  (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.btnLogin);
        signUpBtn = (Button) findViewById(R.id.btnLinkToRegisterScreen);




          loginBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  userLogin();
              }
          });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpAlt.class);
                startActivity(intent);
            }
        });

    }

        public void userLogin(){

            String userEmail = email.getText().toString().trim();
            String userPwd = password.getText().toString().trim();


                if (TextUtils.isEmpty(userEmail) && TextUtils.isEmpty(userPwd)){

                    Toast.makeText(this,"Please enter an email and a password",Toast.LENGTH_LONG).show();
                }

                progressDialog.setMessage("Loging in Please wait...");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(userEmail,userPwd)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressDialog.dismiss();

                                    if (task.isSuccessful()){
                                        // start the profile activity
                                        Toast.makeText(MainActivity.this,"User is logged in successfully",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

        }

}
