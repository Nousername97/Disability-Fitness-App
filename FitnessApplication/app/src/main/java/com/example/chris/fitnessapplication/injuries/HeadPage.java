package com.example.chris.fitnessapplication.injuries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.chris.fitnessapplication.MainActivity;
import com.example.chris.fitnessapplication.R;
import com.example.chris.fitnessapplication.data.Users.UserDetails;
import com.example.chris.fitnessapplication.data.Users.UserDetailsDatabase;

import java.util.ArrayList;


public class HeadPage extends AppCompatActivity{

    private Spinner partSpinner, levelSpinner;
    private Button btnContinue;
    private String bodyPartStr, levelStr;
    private ArrayList<String> disabilityTags;
    UserDetails dataInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headpage);

        partSpinner = (Spinner)findViewById(R.id.partSpinner);
        levelSpinner = (Spinner)findViewById(R.id.levelSpinner);
        btnContinue = (Button)findViewById(R.id.btn_complete);

        setPartContent();
        setLevelContent();

        btnContinue.setOnClickListener (
            new View.OnClickListener() {
                public void onClick (View v) {
                    onContinueButtonClick();
                }
            }
        );
    }

    public void getStrings() {
<<<<<<< HEAD
        bodyPartStr = "Neck";
=======
        bodyPartStr = partSpinner.getSelectedItem().toString();
>>>>>>> eeb2a1ffbafecf11a0fc3cd7fa4612c8a61fbeaf
        levelStr = levelSpinner.getSelectedItem().toString();
    }

    public void onContinueButtonClick() {
        getStrings();
        Intent i = new Intent(HeadPage.this, MainActivity.class);
        startActivity(i);
        UserDetails dataInput =  UserDetailsDatabase.getInstance(this).UserDetailsDao().getUserById(2);
        disabilityTags = dataInput.getDisabilityTags();
        disabilityTags.add(bodyPartStr);
        dataInput.setDisabilityTags(disabilityTags);
        UserDetailsDatabase.getInstance(this).UserDetailsDao().insertNewUser(dataInput);

    }

    private void setPartContent() {
        // method for setting content in the body part spinner
        String[] arraySpinner = new String[] {
                "Neck"
        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        partSpinner.setAdapter(adapter);
    }

    private void setLevelContent() {
        // method for setting content in the level of injury spinner
        String[] arraySpinner = new String[] {
                "1 - Recovering: exercise should be done but not focused",
                "2 - Sprains: exercise should be limited",
                "3 - Breaks or worse: exercise should be avoided"

        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter);
    }
}
