package com.example.chris.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button btnProfile;
    private Button btnHome;
    private Button btnAssess;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        onHomePageButtonClick();
        onProfileButtonClick();
        onAssessButtonClick();
    }

    public void onProfileButtonClick() {

        btnProfile = (Button)findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, Profile.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onHomePageButtonClick() {

        btnHome = (Button)findViewById(R.id.btn_homepage);
        btnHome.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, HomePage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onAssessButtonClick() {

        btnAssess = (Button)findViewById(R.id.btn_assess);
        btnAssess.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, fitnessAssessment.class);
                        startActivity(i);
                    }

                }
        );
    }
}
