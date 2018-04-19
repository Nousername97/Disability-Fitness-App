package com.example.chris.fitnessapplication;

import android.app.ActionBar;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.support.v4.app.Fragment;


import com.example.chris.fitnessapplication.data.Exercises.ExerciseDetailsDatabase;
import com.example.chris.fitnessapplication.data.Exercises.ExercisePopulateDatabase;
import com.example.chris.fitnessapplication.data.Exercises.ExercisesDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomePage extends Fragment{
    private ListView ExersizeList ;
    private ArrayAdapter<String> listAdapter ;
    private Button legsButton;
    private Button tricepButton;
    private Button backButton;
    private Button calfButton;
    private Button absButton;
    private Button shoulderButton;
    private Button bicepsButton;
    private Button chestButton;
    private Button forearmButton;

    private String [] currentArray = new String[]{};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hompage, container, false);

        ExersizeList = rootView.findViewById(R.id.ExersizeList);
        bicepsButton = rootView.findViewById(R.id.btn_biceps);
        legsButton = rootView.findViewById(R.id.btn_legs);
        absButton = rootView.findViewById(R.id.btn_abs);
        chestButton = rootView.findViewById(R.id.btn_chest);
        calfButton = rootView.findViewById(R.id.btn_calf);
        backButton = rootView.findViewById(R.id.btn_back);
        tricepButton = rootView.findViewById(R.id.btn_tricep);
        forearmButton = rootView.findViewById(R.id.btn_forearm);
        shoulderButton = rootView.findViewById(R.id.btn_shoulder);

        exersizeList();
        //onProfileButtonClick();
        onButtonLegsClick();
        onButtonAbsClick();
        onButtonBackClick();
        onButtonCalfClick();
        onButtonChestClick();
        onButtonForearmClick();
        onButtonShoulderClick();
        onButtonTricepsClick();
        onButtonBicepsClick();

        return rootView;
    }

    public void exersizeList() {
        List<String> exersizeList = new ArrayList<String>();
        exersizeList = populateList("biceps");
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
        listAdapter.notifyDataSetChanged();
        ExersizeList.setAdapter( listAdapter );
        ExersizeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(getActivity(), exersizeTemplate.class);
                x.putExtra("ExerciseClicked", ExersizeList.getItemAtPosition(i).toString());
                startActivity(x);
            }
        });
    }

    public void onButtonBicepsClick(){
        bicepsButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View chest) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("biceps");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonLegsClick(){
        legsButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View legs) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("legs");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

    public void onButtonAbsClick(){
        absButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View abs) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("abs");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonChestClick(){
        chestButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View chest) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("chest");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonCalfClick(){
        calfButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View calf) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("calf");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonBackClick(){
        backButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View back) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("back");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonTricepsClick(){
        tricepButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View tricep) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("triceps");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonForearmClick(){
        forearmButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View forearm) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("forearm");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonShoulderClick(){
        shoulderButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View shoulder) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("shoulder");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

    public List<String> populateList(String group)
    {
        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(ExercisePopulateDatabase.populateData());

        List<String> listToBeFilled = new ArrayList<String>();
        List<ExercisesDetails> currentExercise = ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().getExercisesByGroup(group);

        for ( ExercisesDetails temp: currentExercise)
        {
            listToBeFilled.add(temp.getName());
        }

        return  listToBeFilled;
    }
}