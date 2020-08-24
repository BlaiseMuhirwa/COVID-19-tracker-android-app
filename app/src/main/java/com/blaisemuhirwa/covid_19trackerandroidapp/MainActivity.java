package com.blaisemuhirwa.covid_19trackerandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener{
    /* User-Interface */
    private BottomNavigationView navigationView;
    private ImageButton refreshButton;
    private TextView titleTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize user-interface views */
        navigationView = findViewById(R.id.navigationView);
        refreshButton = findViewById(R.id.refreshButton);
        titleTextView = findViewById(R.id.titleTextView);

        /* refresh records on click event */
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        /* handle bottom navigation item clicks */

        return false;
    }
}