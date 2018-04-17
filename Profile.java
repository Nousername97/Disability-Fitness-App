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

import java.util.Calendar;

public class Profile extends AppCompatActivity {

    private EditText firstName, lastName, birthDate, weight, height;
    private Spinner gender;
    private CheckBox isDisabled;
    private Button continueBtn;
    private String str_fname, str_lname, str_bdate, str_weight, str_height;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        disclaimerContent();

        firstName = (EditText)findViewById(R.id.etFirstName);
        lastName = (EditText)findViewById(R.id.etLastName);
        birthDate = (EditText)findViewById(R.id.etBirthDate);
        weight = (EditText)findViewById(R.id.etWeight);
        height = (EditText)findViewById(R.id.etHeight);
        gender = (Spinner)findViewById(R.id.spnGender);
        isDisabled = (CheckBox)findViewById((R.id.chkDisabled));
        continueBtn = (Button)findViewById(R.id.btnContinue);

        // makes DoB text-box non editable
        birthDate.setFocusable(false);
        birthDate.setClickable(true);

        birthDateContent();
        setGenderContent();

        continueBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        onContinueButtonClick();
                    }
                }
        );
    }

    private void getInputs() {
        str_fname = firstName.getText().toString().trim();
        str_lname = lastName.getText().toString().trim();
        str_bdate = birthDate.getText().toString().trim();
        str_weight = weight.getText().toString().trim();
        str_height = height.getText().toString().trim();
    }

    public void onContinueButtonClick() {

        //healthAssessment();
        getInputs();

        if (!validateInput()) {
            Toast.makeText(Profile.this, "Error with validation", Toast.LENGTH_SHORT);
        }
        else
        {
            Toast.makeText(Profile.this, "Success with validation", Toast.LENGTH_SHORT);
            // Navigate to home page if success
            //Intent i = new Intent(Profile.this, HomePage.class);
            //startActivity(i);
        }
    }

    private boolean validateInput() {
        final int CHAR_MAX = 32;
        // kg
        final double WEIGHT_MIN = 10.0;
        final double WEIGHT_MAX = 500.0;
        // cm
        final double HEIGHT_MIN = 50.0;
        final double HEIGHT_MAX = 300.0;

        boolean valid = true;
        int int_weight = 0;
        int int_height = 0;

        try {
            int_weight = Integer.parseInt(str_weight);
            int_height = Integer.parseInt(str_height);
        } catch(NumberFormatException nfe) {

        }

        if (str_fname.isEmpty() || str_fname.length() > CHAR_MAX) {
            firstName.setError("Please enter a valid first name");
            valid = false;
        }
        if (str_lname.isEmpty() || str_lname.length() > CHAR_MAX) {
            lastName.setError("Please enter a valid last name");
            valid = false;
        }
        if (str_bdate.isEmpty()) {
            birthDate.setError("Please enter a valid date of birth");
            valid = false;
        }
        if (str_weight.isEmpty() || int_weight <= WEIGHT_MIN || int_weight >= WEIGHT_MAX) {
            weight.setError("Please enter a valid weight");
            valid = false;
        }
        if (str_height.isEmpty() || int_height <= HEIGHT_MIN || int_height >= HEIGHT_MAX) {
            height.setError("Please enter a valid height");
            valid = false;
        }

        return valid;
    }

    private void setGenderContent() {
        // method for setting content in the gender spinner
        String[] arraySpinner = new String[] {
                "Male", "Female", "Prefer not to say"
        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
    }

    private void birthDateContent() {
        // makes a text field of DoB to chose from

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                    Profile.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d("Profile", "onDateSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                birthDate.setText(date);
            }
        };
    }

    private void disclaimerContent() {
        AlertDialog alert = new AlertDialog.Builder(this).create();

        alert.setTitle("License agreement\n");
        alert.setMessage("The information provided is for general information purposes only. " +
                "We assume no responsibility for errors or omissions in the content on the service" +
                "This app offers health and fitness information and is designed for " +
                "educational purpose only. " +
                "You should not rely on this information as a substitute for, nor does it replaces " +
                "professional medical advice, diagnosis, or treatment. ");

        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "Agree",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alert.show();
    }

    public void healthAssessment() {
        if (isDisabled.isChecked()) {
            // TODO ... link to health assessment class to fill out type of body issues
        }
    }
}
