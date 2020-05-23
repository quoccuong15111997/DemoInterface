package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel implements OnItemClick,GetEdittext,OnClick{
    private Activity activity;
    private RecyclerView recyclerView;
    private List<Student>students;
     TextView textView;
    ListAdapter listAdapter;


    public MainViewModel(Activity activity) {
        this.activity = activity;
        addControls();
        addEvents();
    }

    private void addEvents() {
        textView.setOnClickListener(this);
    }

    private void addControls() {
        textView =activity.findViewById(R.id.textView);
        students= new ArrayList<>();
        recyclerView=activity.findViewById(R.id.recy);
        final LinearLayoutManager linearLayoutManager= new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        /*OnItemClick onItemClick= new OnItemClick() {
            @Override
            public void onClickItem(Student student) {
                //lay dc data student dc click
                //textView.setText(student.getName());
                student.setAvatar(R.drawable.abcxyz);
                listAdapter.notifyDataSetChanged();
            }
        };
        GetEdittext getEdittext= new GetEdittext() {
            @Override
            public void onGet(String s) {

                textView.setText(s);
            }
        };*/
        listAdapter= new ListAdapter(students,activity.getApplicationContext(),this,this);
        recyclerView.setAdapter(listAdapter);
        LoadDataStudent loadDataStudent= new LoadDataStudent() {
            @Override
            public void onLoaded(List<Student> studentss) {
                students.addAll(studentss);
                listAdapter.notifyDataSetChanged();
            }
        };
        fakeData(loadDataStudent);
        listAdapter.notifyDataSetChanged();
        Helper helper= new Helper();
        String s = helper.getContent();
        //System.out.println(s);
        helper.getContent1(new Callback() {
            @Override
            public String getContent(String ss) {
                System.out.println(ss);
                return "Phat";
            }
        });
        addData();
    }

    private void addData() {
        for (Student student : students){
            //AppDatabase.getAppDatabase(activity.getApplicationContext()).userDao().insertOnly(student);
        }
    }

    private void fakeData(LoadDataStudent loadDataStudent){
        List<Student> studentList= new ArrayList<>();
        for (int i =1;i< 50;i++){
            studentList.add(new Student(i,"Student: "+i,R.drawable.avatar_foreground));
        }
        loadDataStudent.onLoaded(studentList);
    }

       @Override
    public void onGet(String s) {

    }

    @Override
    public void onClickItem(Student student) {

    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(activity,Main2Activity.class);
        activity.startActivity(intent);
    }
}
