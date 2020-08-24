package com.blaisemuhirwa.covid_19trackerandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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

    /* fragments */
    private Fragment Home, Statistics;
    private Fragment activeFragment;
    private FragmentManager fragmentManager;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize user-interface views */
        navigationView = findViewById(R.id.navigationView);
        refreshButton = findViewById(R.id.refreshButton);
        titleTextView = findViewById(R.id.titleTextView);
        
        initializeFragments();

        /* refresh records on click event */
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    private void initializeFragments() {
        /* initialize fragments */
        Home = new Home();
        Statistics = new Statistics();
        fragmentManager = getSupportFragmentManager();
        activeFragment = Home;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        /* handle bottom navigation item clicks */
        switch (item.getItemId()) {
            case R.id.navigation_home:
                /* load home data */
                return true;
            case R.id.navigation_statistics:
                /* load the statistics */
                return true;
        }
        return false;
    }
}