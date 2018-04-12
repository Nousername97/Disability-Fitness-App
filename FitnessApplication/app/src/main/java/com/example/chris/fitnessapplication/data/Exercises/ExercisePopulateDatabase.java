package com.example.chris.fitnessapplication.data.Exercises;

import android.util.Log;

import com.example.chris.fitnessapplication.R;

/**
 * Created by Invigorant on 11/04/2018.
 */

public class ExercisePopulateDatabase {

    public static ExercisesDetails populateData() {
        Log.d("prepopulate", "Running");
        return new ExercisesDetails("Dumbbell Curl", "2 Arm Dumb Bell Curl", R.drawable.picture, "\\exercises\\triceps\\One Arm Dumb-bell Curl\\instructions.png", "biceps");
    }
}
