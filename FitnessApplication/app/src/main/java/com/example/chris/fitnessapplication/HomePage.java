package com.example.chris.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class HomePage extends AppCompatActivity {
    private ListView ExersizeList ;
    private ArrayAdapter<String> listAdapter ;
    private Button profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hompage);

        exersizeList();
        onProfileButtonClick();
    }

    private void exersizeList() {
        ExersizeList = (ListView) findViewById(R.id.ExersizeList);
        String[] bicepsArray = new String[] {"Dumbbell Curl", "Hammer Curl", "Kneeling Single arm Curl",
                "Cable bicep Curls", "Stability ball Dumbell Bicep curl seated",
                "Test line 1", "Test line 2", "Test line 3", "Test line 4", "Test line 5",
                "Test Line 6", "Test line 7", "Test line 8", "Test line 9", "Test line 10" };
        ArrayList<String> exersizeList = new ArrayList<String>();
        exersizeList.addAll(Arrays.asList(bicepsArray));
        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
        ExersizeList.setAdapter( listAdapter );
    }

    public void onProfileButtonClick() {

        profileBtn = (Button)findViewById(R.id.btn_profile);
        profileBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(HomePage.this, Profile.class);
                        startActivity(i);
                    }
                }
        );
    }
}
