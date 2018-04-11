package com.example.chris.fitnessapplication.data.Users;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class UserDetailsRepo {

   private final UserDetailsDao userDetailsDoa;

    @Inject
    public  UserDetailsRepo (UserDetailsDao userDetailsDoa)
    {
        this.userDetailsDoa = userDetailsDoa;
    }

    public LiveData<List<UserDetails>> getListOfUserDetails()
    {
        return userDetailsDoa.getUsers();
    }

    public LiveData<UserDetails> getUserDetailsById(String userId)
    {
        return userDetailsDoa.getUserById(userId);
    }

    public void insertNewUser(UserDetails userDetails)
    {
        userDetailsDoa.insertNewUser(userDetails);
    }

    public void deleteUser (UserDetails userDetails)
    {
        userDetailsDoa.deleteUser(userDetails);
    }
}
