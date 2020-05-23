package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;

    private static final String DATABASE_NAME = "movies_db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel= new MainViewModel(this);
        initDatabase();
    }

    private void initDatabase() {

    }
}
