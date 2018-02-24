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

    private EditText firstName;
    private EditText lastName;
    private EditText birthDate;
    private EditText weight;
    private EditText height;
    private Spinner gender;
    private CheckBox isDisabled;
    private Button continueBtn; //continue is an inbuilt keyword

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

        birthDateContent();
        setGenderContent();
        onContinueButtonClick();
    }

    public void onContinueButtonClick() {

        emptyFields();
        //validate();
        //healthAssessment();

        continueBtn = (Button)findViewById(R.id.btnContinue);
        continueBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Profile.this, HomePage.class);
                        startActivity(i);
                    }
                }
        );
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

    private void emptyFields() {

        // handles empty fields individually
        if (TextUtils.isEmpty(firstName.getText().toString())) {
            firstName.setError("First name is required!");
        }

        if (TextUtils.isEmpty(lastName.getText().toString())) {
            lastName.setError("Last name is required!");
        }

        if (TextUtils.isEmpty(weight.getText().toString())) {
            weight.setError("Weight input is required!");
        }

        if (TextUtils.isEmpty(height.getText().toString())) {
            height.setError("Height input is required!");
        }
    }

    private void validate() {

        // min and max for height and weight
        final double WEIGHT_MIN = 10.0;
        final double WEIGHT_MAX = 500.0;
        final double HEIGHT_MIN = 50.0;
        final double HEIGHT_MAX = 300.0;

        //double validatedWeight = Integer.valueOf(weight.getText().toString());
        //double validatedHeight = Integer.valueOf(height.getText().toString());
        double validatedWeight = 10;
        double validatedHeight = 10;

        if (firstName.getText().toString().length() <= 3) {
            firstName.setError("First name has to be more than 3 characters!");
        }

        if (lastName.getText().toString().length() <= 3) {
            lastName.setError("Last name has to be more than 3 characters!");
        }

        if (validatedWeight < WEIGHT_MIN || validatedWeight > WEIGHT_MAX) {
            weight.setError("Weight input must be between 10kg and 500kg!");
        }

        if (validatedHeight < HEIGHT_MIN|| validatedHeight > HEIGHT_MAX) {
            height.setError("Height input must be between 50cm and 300cm!");
        }
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
