package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAccess {
    @Insert
    void insertOnly (Student student);
    @Query("SELECT * FROM Student WHERE Id =:id")
    List<Student> getAll(int id);
}
