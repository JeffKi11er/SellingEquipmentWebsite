package com.t3h.myprojectnoteupdate.item;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.t3h.myprojectnoteupdate.EventModel;

@Entity
public class Item extends EventModel {
    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "description")
    private String title;
    private String description;


    @ColumnInfo(name = "date")
    private String time;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
