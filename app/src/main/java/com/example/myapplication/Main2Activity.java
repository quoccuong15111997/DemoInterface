package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initDatabase();
    }

    private void initDatabase() {
        List<Student> studentList = AppDatabase.getAppDatabase(getApplicationContext()).userDao().getAll(1);
        for (Student student : studentList){
            System.out.println(student.getName());
        }
    }
}
