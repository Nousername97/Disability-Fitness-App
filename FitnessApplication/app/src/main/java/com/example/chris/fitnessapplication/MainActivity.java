package com.example.chris.fitnessapplication;

import android.app.LauncherActivity;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private ListView ExersizeList ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExersizeList = (ListView) findViewById(R.id.ExersizeList);
        String[] bicepsArray = new String[] {"Dumbbell Curl", "Hammer Curl", "Kneeling Single arm Curl",
                "Cable bicep Curls", "Stability ball Dumbell Bicep curl seated",
                "Test line 1", "Test line 2", "Test line 3", "Test line 4", "Test line 5",
                "Test Line 6", "Test line 7", "Test line 8", "Test line 9", "Test line 10" };
        ArrayList<String> exersizeList = new ArrayList<String>();
        exersizeList.addAll(Arrays.asList(bicepsArray));
        listAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.simplerow, exersizeList);
        ExersizeList.setAdapter( listAdapter );


    }


}
