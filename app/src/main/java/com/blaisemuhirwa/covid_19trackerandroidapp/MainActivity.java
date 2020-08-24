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
    private Fragment home, statistics;
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
        home = new Home();
        statistics = new Statistics();
        fragmentManager = getSupportFragmentManager();
        activeFragment = home;
        fragmentManager.beginTransaction().add(R.id.frameLayout, home, "Home").commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout, statistics, "Statistics")
                .hide(statistics)
                .commit();

    }
    private void loadHomeFragment() {
        titleTextView.setText("HOME");
        fragmentManager.beginTransaction().hide(activeFragment).show(home).commit();
        activeFragment = home;
    }
    private void loadStatisticsFragment() {
        titleTextView.setText("COVID-19 STATISTICS");
        fragmentManager.beginTransaction().hide(activeFragment).show(statistics).commit();
        activeFragment = statistics;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        /* handle bottom navigation item clicks */
        switch (item.getItemId()) {
            case R.id.navigation_home:
                /* load home data */
                loadHomeFragment();
                return true;
            case R.id.navigation_statistics:
                /* load the statistics */
                loadStatisticsFragment();
                return true;
        }
        return false;
    }
}