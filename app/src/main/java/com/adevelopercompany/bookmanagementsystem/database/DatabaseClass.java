package com.adevelopercompany.bookmanagementsystem.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.adevelopercompany.bookmanagementsystem.entities.EntityBooks;
import com.adevelopercompany.bookmanagementsystem.entities.EntityClasses;
import com.adevelopercompany.bookmanagementsystem.entities.EntityImages;
import com.adevelopercompany.bookmanagementsystem.entities.EntityTopics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EntityBooks.class, EntityClasses.class, EntityImages.class, EntityTopics.class}, version = 1)
public abstract class DatabaseClass extends RoomDatabase {

    public static DatabaseClass INSTANCE;

    public abstract DaoClass getDaoClass();

    public static final int NO_OF_THREADS = 4;

    public static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NO_OF_THREADS);

    public static DatabaseClass getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseClass.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseClass.class, "book_management_system").createFromAsset("database/DatabaseClass.db").build();

                }

            }

        }

        return INSTANCE;
    }
}
