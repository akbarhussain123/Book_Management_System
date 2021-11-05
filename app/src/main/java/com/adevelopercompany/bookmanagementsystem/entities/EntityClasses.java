package com.adevelopercompany.bookmanagementsystem.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EntityClasses {

    @PrimaryKey (autoGenerate = true)
    int classId;
    String className;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public EntityClasses(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }
}
