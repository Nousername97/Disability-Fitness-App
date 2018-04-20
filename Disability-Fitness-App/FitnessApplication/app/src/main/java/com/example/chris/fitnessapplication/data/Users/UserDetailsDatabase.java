package com.example.chris.fitnessapplication.data.Users;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Invigorant on 05/03/2018.
 */

@Database(entities = {UserDetails.class}, version = 1)
public abstract class UserDetailsDatabase extends RoomDatabase{

    public abstract  UserDetailsDao UserDetailsDao();

}
