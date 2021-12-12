package com.adevelopercompany.bookmanagementsystem.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EntityImages {

    @PrimaryKey
    int id;
    byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public EntityImages(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }
}
