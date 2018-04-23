package com.example.chris.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chris.fitnessapplication.data.Exercises.ExerciseDetailsDatabase;
import com.example.chris.fitnessapplication.data.Exercises.ExercisesDetails;

/**
 * Created by Chris on 19/02/2018.
 */

public class exersizeTemplate extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exersizetemplate);

        Intent intent = getIntent();
        String exercise = intent.getStringExtra("ExerciseClicked");

        ExercisesDetails currentExercise = ExerciseDetailsDatabase.getInstance(exersizeTemplate.this).exercisesDetailsDao().getExerciseByName(exercise);


        TextView exerciseTitle = (TextView)findViewById(R.id.textView);
        exerciseTitle.setText(currentExercise.getName());

        ImageView exerciseImage = (ImageView)findViewById(R.id.imageView);
        exerciseImage.setImageResource(currentExercise.getExerciseImagePath());

        TextView excerciseDescription = findViewById(R.id.textView2);
        excerciseDescription.setText(currentExercise.getInstructionsImagePath());

    }
}
