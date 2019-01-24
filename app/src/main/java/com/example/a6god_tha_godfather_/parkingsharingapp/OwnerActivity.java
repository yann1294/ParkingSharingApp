package com.example.a6god_tha_godfather_.parkingsharingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.a6god_tha_godfather_.parkingsharingapp.ownerActivities.OwnerInterfaceActivity;

public class OwnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void goToMainOwnerInterface(View view) {
        Intent intent = new Intent(this, OwnerInterfaceActivity.class);
        startActivity(intent);

    }
}
