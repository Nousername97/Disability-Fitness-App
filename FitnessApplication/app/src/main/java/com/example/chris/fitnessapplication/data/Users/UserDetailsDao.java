package com.example.chris.fitnessapplication.data.Users;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDetailsDao {

    @Query("SELECT * FROM UserDetails")
    LiveData<List<UserDetails>> getUsers();

    @Query("SELECT * FROM UserDetails WHERE userID = :userID")
    LiveData<UserDetails> getUserById(String userID);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertNewUser(UserDetails userDetails);

    @Delete
    void  deleteUser(UserDetails userDetails);

}
