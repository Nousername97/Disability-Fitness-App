package com.example.chris.fitnessapplication.data.Exercises;

import android.util.Log;

/**
 * Created by Invigorant on 11/04/2018.
 */

public class ExercisePopulateDatabase {

    public static ExercisesDetails[] populateData() {
        Log.d("prepopulate", "Running");
        return new ExercisesDetails[] {
                new ExercisesDetails("DDumbbell Curl", "1 Arm Dumb Bell Curl", "\\exercises\\triceps\\One Arm Dumb-bell Curl\\picture.png", "\\exercises\\triceps\\One Arm Dumb-bell Curl\\instructions.pngg")
        };
    }
}
