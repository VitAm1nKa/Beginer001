package com.example.beginer001;

import com.orm.SugarRecord;

public class Test extends SugarRecord {
    String name;
    public Test() {}
    public Test(String name) {
        this.name = name;
    }
}
