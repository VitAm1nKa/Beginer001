package com.example.beginer001;

import com.orm.SugarRecord;

public class Limpopo extends SugarRecord {

    String name;
    int age;

    public Limpopo() {}

    public Limpopo(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
