package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Student {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Avatar")
    private int avatar;
    public Student() {
    }

    public Student(int id, String name, int avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
