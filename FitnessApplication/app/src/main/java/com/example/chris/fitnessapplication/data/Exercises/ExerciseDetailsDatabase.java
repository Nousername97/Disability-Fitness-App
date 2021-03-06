package com.example.chris.fitnessapplication.data.Exercises;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.chris.fitnessapplication.data.Converters;

import java.util.concurrent.Executors;

@Database(entities = {ExercisesDetails.class}, version = 7)
@TypeConverters({Converters.class})
public abstract class ExerciseDetailsDatabase extends RoomDatabase {


    private static volatile ExerciseDetailsDatabase instance;
    public abstract ExercisesDetailsDao exercisesDetailsDao();

    public static synchronized ExerciseDetailsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static ExerciseDetailsDatabase create(final Context context) {
        Log.d("Prepopulate", "run: creating db");
        return Room.databaseBuilder(
                context,
                ExerciseDetailsDatabase.class,
                "exercise database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addCallback(new Callback() {
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
             }
          })
         .build();
    }

}
