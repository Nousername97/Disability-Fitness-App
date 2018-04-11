package com.example.chris.fitnessapplication.data.Exercises;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ExercisesDetails {

    @PrimaryKey @NonNull
    private String exerciseID;

    @ColumnInfo(name =  "name")
    private String name;

    @ColumnInfo(name =  "exerciseImagePath")
    private String exerciseImagePath;

    @ColumnInfo(name =  "instructionsImagePath")
    private String instructionsImagePath;

    //Initializer to add new users
    public ExercisesDetails (String exerciseID, String name, String exerciseImagePath, String instructionsImagePath)
    {
        this.exerciseID = exerciseID;
        this.name = name;
        this.exerciseImagePath = exerciseImagePath;
        this.instructionsImagePath = instructionsImagePath;

    }

    //region Getters and Setters

    public void setExerciseID(String exerciseID) { this.exerciseID = exerciseID; }
    public String getExerciseID() { return exerciseID; }

    public void setName(String name) { this.name = name; }
    public String getName() {
        return name;
    }

    public void setExerciseImagePath(String exerciseImagePath) { this.exerciseImagePath = exerciseImagePath; }
    public String getExerciseImagePath() { return exerciseImagePath; }

    public void setInstructionsImagePath(String instructionsImagePath) { this.instructionsImagePath = instructionsImagePath; }
    public String getInstructionsImagePath() {
        return instructionsImagePath;
    }

    //endregion

}