package com.example.beginer001.beginerModel;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

@Table(name = "t_order")
public class Order extends SugarRecord {

    String title;

    public Order() {
    }

    public Order(String title) {
        this.title = title;
    }
}
