package com.adevelopercompany.bookmanagementsystem.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.adevelopercompany.bookmanagementsystem.entities.EntityImages;

import java.util.List;

@Dao
public interface DaoClass {

    @Query("select * from EntityImages ")
    LiveData<List<EntityImages>> getAllData();
}
