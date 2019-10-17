package com.example.beginer001;

import com.orm.SugarRecord;

import java.util.Date;

public class Order extends SugarRecord {

    String added;
    String modified;


    public Order(String added, String modified) {
        this.added = added;
        this.modified = modified;
    }

    public Order() {
    }
}
