package com.example.chris.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button btnProfile;
    private Button btnHome;
    private Button btnAssessment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

        // Default page on app startup
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Profile()).commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomePage()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomePage();
                            break;
                        case R.id.navigation_profile:
                            selectedFragment = new Profile();
                            break;
                        case R.id.navigation_health:
                            selectedFragment = new fitnessAssessment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//        onHomePageButtonClick();
//        onProfileButtonClick();
//        onAssessmentButtonClick();
//    }
//
//    public void onProfileButtonClick() {
//
//        btnProfile = (Button)findViewById(R.id.btn_profile);
//        btnProfile.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent i = new Intent(MainActivity.this, Profile.class);
//                        startActivity(i);
//                    }
//                }
//        );
//    }
//
//    public void onHomePageButtonClick() {
//
//        btnHome = (Button)findViewById(R.id.btn_homepage);
//        btnHome.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent i = new Intent(MainActivity.this, HomePage.class);
//                        startActivity(i);
//                    }
//                }
//        );
//    }
//    public void onAssessmentButtonClick() {
//
//        btnAssessment = (Button)findViewById(R.id.btn_assess);
//        btnAssessment.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent i = new Intent(MainActivity.this, fitnessAssessment.class);
//                        startActivity(i);
//                    }
//                }
//        );
//    }

}
