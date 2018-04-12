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

import com.example.chris.fitnessapplication.data.Exercises.ExerciseDetailsDatabase;
import com.example.chris.fitnessapplication.data.Exercises.ExercisePopulateDatabase;
import com.example.chris.fitnessapplication.data.Exercises.ExercisesDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    private
    String [] currentArray = new String[]{};

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
    }



    public void exersizeList() {
        ExersizeList = findViewById(R.id.ExersizeList);
        List<String> exersizeList = new ArrayList<String>();
        exersizeList = populateList("biceps");
        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
        listAdapter.notifyDataSetChanged();
        ExersizeList.setAdapter( listAdapter );
        ExersizeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(HomePage.this, exersizeTemplate.class);
                x.putExtra("ExerciseClicked", ExersizeList.getItemAtPosition(i).toString());
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("biceps");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("legs");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("abs");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("chest");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("calf");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("back");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("triceps");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("forearm");
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
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("shoulder");
                        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

    public List<String> populateList(String group)
    {
        ExerciseDetailsDatabase.getInstance(this).exercisesDetailsDao().insertNewExercise(ExercisePopulateDatabase.populateData());

        List<String> listToBeFilled = new ArrayList<String>();
        List<ExercisesDetails> currentExercise = ExerciseDetailsDatabase.getInstance(this).exercisesDetailsDao().getExercisesByGroup(group);

        for ( ExercisesDetails temp: currentExercise)
        {
            listToBeFilled.add(temp.getName());
        }

        return  listToBeFilled;
    }
}