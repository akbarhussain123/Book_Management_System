package com.adevelopercompany.bookmanagementsystem.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EntityTopics {
@PrimaryKey (autoGenerate = true)
    int topicId;
    int bookId;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public EntityTopics(int topicId, int bookId, String topicTitle) {
        this.topicId = topicId;
        this.bookId = bookId;
        this.topicTitle = topicTitle;
    }

    String topicTitle;
}
