package com.adevelopercompany.bookmanagementsystem.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EntityBooks {
    @PrimaryKey(autoGenerate = true)
    int bookId;
    String bookTitle;
    int classId;

    public EntityBooks(int bookId, String bookTitle, int classId) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.classId = classId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
