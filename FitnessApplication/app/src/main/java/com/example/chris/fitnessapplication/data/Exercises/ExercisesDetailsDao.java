package com.example.chris.fitnessapplication.data.Exercises;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExercisesDetailsDao {


    @Query("SELECT * FROM  ExercisesDetails")
    LiveData<List<ExercisesDetails>> getExercises();

    @Query("SELECT * FROM ExercisesDetails WHERE exerciseID = :exerciseID")
    ExercisesDetails getExerciseById(String exerciseID);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertNewExercise(ExercisesDetails exercisesDetails);

    @Insert
    void insertAll(ExercisesDetails... exercisesDetails);

    @Delete
    void  deleteExercise(ExercisesDetails exercisesDetails);

    @Query("DELETE FROM ExercisesDetails")
    public void nukeTable();


}
