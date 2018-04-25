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
    List<UserDetails> getUsers();

    @Query("SELECT * FROM UserDetails WHERE userID = :userID")
    UserDetails getUserById(int userID);

//    @Query("SELECT * FROM UserDetails WHERE firstName = :firstName")
//    String getUserByName (String firstName);

    @Query("SELECT COUNT(*) FROM UserDetails")
    int countUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertNewUser(UserDetails userDetails);

    @Delete
    void  deleteUser(UserDetails userDetails);
}
