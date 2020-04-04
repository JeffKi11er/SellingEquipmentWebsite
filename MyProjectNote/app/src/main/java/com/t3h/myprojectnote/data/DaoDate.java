package com.t3h.myprojectnote.data;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.t3h.myprojectnote.item.Item;

import java.util.List;

@Dao
public interface DaoDate {
    @Query("SELECT * FROM Item ")
    List<Item>getAll();
    @Query("SELECT * FROM Item WHERE id =:taskID")
    List<Item>getTask(int taskID);
    @Insert
    void insert(Item... items);
    @Update
    void update(Item... items);
    @Delete
    void delete(Item... items);
}
