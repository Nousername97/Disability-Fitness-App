package com.example.chris.fitnessapplication.data.Exercises;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.chris.fitnessapplication.data.Converters;

import java.util.ArrayList;

@Entity
public class ExercisesDetails {

    @PrimaryKey @NonNull
    private String exerciseID;

    @ColumnInfo(name =  "name")
    private String name;

    @ColumnInfo(name = "grouping" )
    private  String grouping;

    @ColumnInfo(name =  "exerciseImagePath")
    private int exerciseImagePath;

    @ColumnInfo(name =  "instructionsImagePath")
    private String instructionsImagePath;

    @TypeConverters({Converters.class})
    @ColumnInfo(name = "disabilityTags")
    private ArrayList<String> disabilityTags;


    //Initializer to add new users
    public ExercisesDetails (String exerciseID, String name, int exerciseImagePath, String instructionsImagePath, String grouping, ArrayList<String> disabilityTags)
    {
        this.exerciseID = exerciseID;
        this.name = name;
        this.grouping = grouping;
        this.exerciseImagePath = exerciseImagePath;
        this.instructionsImagePath = instructionsImagePath;
        this.disabilityTags = disabilityTags;

    }

    //region Getters and Setters

    public void setExerciseID(String exerciseID) { this.exerciseID = exerciseID; }
    public String getExerciseID() { return exerciseID; }

    public void setGrouping(String grouping) { this.grouping = grouping; }
    public String getGrouping() {
        return grouping;
    }

    public void setName(String name) { this.name = name; }
    public String getName() {
        return name;
    }

    public void setExerciseImagePath(int exerciseImagePath) { this.exerciseImagePath = exerciseImagePath; }
    public int getExerciseImagePath() { return exerciseImagePath; }

    public void setInstructionsImagePath(String instructionsImagePath) { this.instructionsImagePath = instructionsImagePath; }
    public String getInstructionsImagePath() {
        return instructionsImagePath;
    }

    public void setDisabilityTags(ArrayList<String> disabilityTags) {        this.disabilityTags = disabilityTags;    }
    public ArrayList<String> getDisabilityTags() {        return disabilityTags;    }
    //endregion

}