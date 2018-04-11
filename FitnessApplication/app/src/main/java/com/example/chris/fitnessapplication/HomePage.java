package com.example.chris.fitnessapplication;

import android.app.ActionBar;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class HomePage extends AppCompatActivity {
    private ListView ExersizeList ;
    private ArrayAdapter<String> listAdapter ;
    private Button profileBtn;
    private Button legsButton;
    private Button tricepButton;
    private Button backButton;
    private Button calfButton;
    private Button absButton;
    private Button shoulderButton;
    private Button bicepsButton;
    private Button chestButton;
    private Button forearmButton;
    String [] currentArray = new String[]{};
    String[] bicepsArray = new String[] {"Dumbbell Curl", "Hammer Curl", "Kneeling Single arm Curl",
            "Cable bicep Curls", "Stability ball Dumbell Bicep curl seated"};//populate each of these arrays with the appropriate database content
    String[] legsArray = new String[] {"leg content line 1", "Leg content line 2"};//populate each of these arrays with the appropriate database content
    String[] backArray = new String[] {"back content line 1", "back content line 2"};//populate each of these arrays with the appropriate database content
    String[] absArray = new String[] {"abs content line 1", "abs content line 2"};//populate each of these arrays with the appropriate database content
    String[] calfArray = new String[] {"calf content line 1", "calf content line 2"};//populate each of these arrays with the appropriate database content
    String[] chestArray = new String[] {"chest content line 1", "chest content line 2"};//populate each of these arrays with the appropriate database content
    String[] forearmArray = new String[] {"forearm content line 1", "forearm content line 2"};//populate each of these arrays with the appropriate database content
    String[] shoulderArray = new String[] {"Shoulder content line 1", "Shoulder content line 2"};//populate each of these arrays with the appropriate database content
    String[] tricepsArray = new String[] {"Tricpes content line 1", "Triceps content line 2"};//populate each of these arrays with the appropriate database content
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hompage);
        exersizeList();
        onProfileButtonClick();
        onButtonLegsClick();
        onButtonAbsClick();
        onButtonBackClick();
        onButtonCalfClick();
        onButtonChestClick();
        onButtonForearmClick();
        onButtonShoulderClick();
        onButtonTricepsClick();
        onButtonBicepsClick();
        currentArray = bicepsArray;
    }



    public void exersizeList() {
        ExersizeList = findViewById(R.id.ExersizeList);
        ArrayList<String> exersizeList = new ArrayList<String>();
        exersizeList.addAll(Arrays.asList(currentArray));
        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
        listAdapter.notifyDataSetChanged();
        ExersizeList.setAdapter( listAdapter );
        ExersizeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(HomePage.this, exersizeTemplate.class);
                startActivity(x);
            }
        });
    }

    public void onProfileButtonClick() {

        profileBtn = findViewById(R.id.btn_profile);
        profileBtn.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(HomePage.this, Profile.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onButtonBicepsClick(){
        bicepsButton = findViewById(R.id.btn_biceps);
        bicepsButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View chest) {
                        listAdapter.clear();
                        currentArray = bicepsArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonLegsClick(){
        legsButton = findViewById(R.id.btn_legs);
        legsButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View legs) {
                        listAdapter.clear();
                        currentArray = legsArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

    public void onButtonAbsClick(){
        absButton = findViewById(R.id.btn_abs);
        absButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View abs) {
                        listAdapter.clear();
                        currentArray = absArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonChestClick(){
        chestButton = findViewById(R.id.btn_chest);
        chestButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View chest) {
                        listAdapter.clear();
                        currentArray = chestArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonCalfClick(){
        calfButton = findViewById(R.id.btn_calf);
        calfButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View calf) {
                        listAdapter.clear();
                        currentArray = calfArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonBackClick(){
        backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View back) {
                        listAdapter.clear();
                        currentArray = backArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonTricepsClick(){
        tricepButton = findViewById(R.id.btn_tricep);
        tricepButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View tricep) {
                        listAdapter.clear();
                        currentArray = tricepsArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonForearmClick(){
        forearmButton = findViewById(R.id.btn_forearm);
        forearmButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View forearm) {
                        listAdapter.clear();
                        currentArray = forearmArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonShoulderClick(){
        shoulderButton = findViewById(R.id.btn_shoulder);
        shoulderButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View shoulder) {
                        listAdapter.clear();
                        currentArray = shoulderArray;
                        ArrayList<String> exersizeList = new ArrayList<String>();
                        exersizeList.addAll(Arrays.asList(currentArray));
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

}