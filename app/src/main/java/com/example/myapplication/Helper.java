package com.example.myapplication;

public class Helper {
    public Helper(){

    }
    public String getContent(){
        return "Nguyen Quoc Cuong";
    }
    public void getContent1(Callback callback){
        String s = callback.getContent("Nguyen Quoc Cuong");
        callback.getContent(s+"abc");
        System.out.println(s);
    }
}
