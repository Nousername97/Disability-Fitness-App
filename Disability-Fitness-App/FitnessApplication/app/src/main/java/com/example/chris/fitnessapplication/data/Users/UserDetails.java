package com.example.chris.fitnessapplication.data.Users;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UserDetails {

    @PrimaryKey
    private int userID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String weight;
    private String height;
    private String gender;

    //Initializer to add new users
    public UserDetails (int userID, String firstName, String lastName, String dateOfBirth, String weight, String height, String gender)
    {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    //region Getters and Setters
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getUserID() {
        return userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getWeight() {
        return weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    public String getHeight() {
        return height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    //endregion

    public static UserDetails[] populateData() {
        return new UserDetails[] {
          new UserDetails(1, "James", "Brookes", "01/06/1998", "70", "183", "Male")
        };
    }
}
