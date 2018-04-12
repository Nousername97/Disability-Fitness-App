package com.example.chris.fitnessapplication;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Mike1 on 09/04/2018.
 */

public class fitnessAssessment extends AppCompatActivity {

    private Button headButton;
    private Button rArmButton;
    private Button lArmButton;
    private Button torsoButton;
    private Button legsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitnessassessment);

        headButton = (Button)findViewById(R.id.btn_head);
        rArmButton = (Button)findViewById(R.id.btn_rightarm);
        lArmButton = (Button)findViewById(R.id.btn_leftarm);
        torsoButton = (Button)findViewById(R.id.btn_torso);
        legsButton = (Button)findViewById(R.id.btn_legs);

        onHeadClick();
        /*onRightArmClick();
        onLeftArmClick();
        onTorsoClick();
        onLegsClick();*/
    }

    public void onHeadClick() {

        headButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(fitnessAssessment.this, HeadPage.class);
                        startActivity(i);
                    }
                }
        );
    }

}
