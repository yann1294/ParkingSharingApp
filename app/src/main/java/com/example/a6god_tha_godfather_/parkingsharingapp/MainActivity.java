package com.example.a6god_tha_godfather_.parkingsharingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button goToSignUp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void signUpAlt(View view){
        Intent intent = new Intent(this,SignUpAlt.class);
        startActivity(intent);
    }
}
