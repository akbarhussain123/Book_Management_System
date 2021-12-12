package com.adevelopercompany.bookmanagementsystem.viewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adevelopercompany.bookmanagementsystem.database.DaoClass;
import com.adevelopercompany.bookmanagementsystem.database.DatabaseClass;
import com.adevelopercompany.bookmanagementsystem.entities.EntityGnImages;
import com.adevelopercompany.bookmanagementsystem.entities.EntityImages;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ViewModelBookImages extends AndroidViewModel {
    DatabaseClass database;
    DaoClass daoClass;
    Application application;

    public LiveData<List<EntityImages>> imgList = new MutableLiveData<>();
    public LiveData<List<EntityGnImages>> gnImageList = new MutableLiveData<>();

    public ViewModelBookImages(@NonNull @NotNull Application application) {
        super(application);
        database = DatabaseClass.getDatabase(application);
        daoClass = database.getDaoClass();
        this.application = application;
    }

    public void getAllData(String name) {
        DatabaseClass.databaseExecutor.execute(new Runnable() {
            @Override
            public void run() {
                if (name.equals("english")) {
                    imgList = daoClass.getAllEnglishData();
                 //   Log.d("name"," items = "+imgList.getValue());


                } else if (name.equals("gn")) {
                    gnImageList = daoClass.getAllGnData();
                 Log.d("name"," items = "+gnImageList.getValue());
                }
            }
        });
    }

}
