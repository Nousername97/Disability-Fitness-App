package com.example.chris.fitnessapplication;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by kelvin on 18/04/2018.
 */

public class Profile extends Fragment {

    private EditText firstName, lastName, birthDate, weight, height;
    private Spinner gender;
    private CheckBox isDisabled;
    private Button continueBtn;
    private String str_fname, str_lname, str_bdate, str_weight, str_height;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_profile, container, false);
        disclaimerContent();

        firstName = (EditText)rootView.findViewById(R.id.etFirstName);
        lastName = (EditText)rootView.findViewById(R.id.etLastName);
        birthDate = (EditText)rootView.findViewById(R.id.etBirthDate);
        weight = (EditText)rootView.findViewById(R.id.etWeight);
        height = (EditText)rootView.findViewById(R.id.etHeight);
        gender = (Spinner)rootView.findViewById(R.id.spnGender);
        continueBtn = (Button)rootView.findViewById(R.id.btnContinue);

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

        return rootView;
    }

    private void getInputs() {
        str_fname = firstName.getText().toString().trim();
        str_lname = lastName.getText().toString().trim();
        str_bdate = birthDate.getText().toString().trim();
        str_weight = weight.getText().toString().trim();
        str_height = height.getText().toString().trim();
    }

    public void onContinueButtonClick() {
        getInputs();

        if (!validateInput()) {
            Toast.makeText(getActivity(), "Error with validation", Toast.LENGTH_SHORT);
        }
        else
        {
            Toast.makeText(getActivity(), "Success with validation", Toast.LENGTH_SHORT);

            // TODO Save to database
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
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinner);
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
                        getActivity(),
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
        AlertDialog alert = new AlertDialog.Builder(getActivity()).create();

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
}
