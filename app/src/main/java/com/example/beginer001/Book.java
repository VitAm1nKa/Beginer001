package com.example.beginer001;

import android.util.Log;

import com.orm.SugarRecord;

public class Book extends SugarRecord {
    String title;
    String author;
    public Book() { }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
}

