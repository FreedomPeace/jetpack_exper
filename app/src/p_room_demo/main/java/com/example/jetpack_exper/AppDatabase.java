package com.example.jetpack_exper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    private static AppDatabase ourInstance;

    static AppDatabase getInstance(Context context) {
        synchronized (AppDatabase.class) {
            if (ourInstance == null) {
                synchronized (AppDatabase.class) {
                    ourInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "jack.db")
                            .build();
                }
            }
        }
        return ourInstance;
    }

    private AppDatabase() {
    }
}
