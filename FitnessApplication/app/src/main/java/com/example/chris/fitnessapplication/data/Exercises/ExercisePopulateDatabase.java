package com.example.chris.fitnessapplication.data.Exercises;

import android.util.Log;

import com.example.chris.fitnessapplication.R;

/**
 * Created by Invigorant on 11/04/2018.
 */

public class ExercisePopulateDatabase {

    public static ExercisesDetails populateData() {
        Log.d("prepopulate", "Running");
        return new ExercisesDetails("One Armed Dumb-Bell Curl", "One Armed Dumb-Bell Curl", R.drawable.onehandeddumbbellcurl, "Stand Holding the Dumb-Bell with your palms facing upwards, curl the Dumb-Bell upwards as far as possible then slowly lower the weight down without it touching your body.", "biceps");
}

}
