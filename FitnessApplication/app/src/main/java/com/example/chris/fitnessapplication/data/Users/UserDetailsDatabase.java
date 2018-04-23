package com.example.chris.fitnessapplication.data.Users;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.concurrent.Executors;

/**
 * Created by Invigorant on 05/03/2018.
 */

@Database(entities = {UserDetails.class}, version = 2)
public abstract class UserDetailsDatabase extends RoomDatabase{

    public abstract  UserDetailsDao UserDetailsDao();

    private static volatile UserDetailsDatabase instance;

    public static synchronized UserDetailsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static UserDetailsDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                UserDetailsDatabase.class,
                "user database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
