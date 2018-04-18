package com.example.chris.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class fitnessAssessment extends AppCompatActivity {

    private Button headButton;
    private Button rArmButton;
    private Button lArmButton;
    private Button torsoButton;
    private Button legsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        headButton = (Button)findViewById(R.id.btn_head);
        rArmButton = (Button)findViewById(R.id.btn_rightarm);
        lArmButton = (Button)findViewById(R.id.btn_leftarm);
        torsoButton = (Button)findViewById(R.id.btn_torso);
        legsButton = (Button)findViewById(R.id.btn_legs);

        onHeadClick();
        onRightArmClick();
        onLeftArmClick();
        onTorsoClick();
        onLegsClick();
    }

    public void onHeadClick() {

        headButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(fitnessAssessment.this, HeadPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onTorsoClick() {

        torsoButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(fitnessAssessment.this, TorsoPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onLegsClick() {

        legsButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(fitnessAssessment.this, LegsPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onRightArmClick() {

        rArmButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(fitnessAssessment.this, rArmPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onLeftArmClick() {

        lArmButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(fitnessAssessment.this, lArmPage.class);
                        startActivity(i);
                    }
                }
        );
    }

}
