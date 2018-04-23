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


public class rArmPage extends AppCompatActivity{

    private Spinner partSpinner, levelSpinner;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rarmpage);

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

    public void onContinueButtonClick() {
        Intent i = new Intent(rArmPage.this, MainActivity.class);
        startActivity(i);
    }

    private void setPartContent() {
        // method for setting content in the body part spinner
        String[] arraySpinner = new String[] {
                "Shoulder", "Bicep", "Tricep", "Elbow", "Ulna", "Radius", "Wrist", "Hand", "Whole Arm"
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
                "3 - Severe injury/condition: exercise should be avoided"

        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter);
    }
}
