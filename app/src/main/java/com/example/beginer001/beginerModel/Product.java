package com.example.beginer001.beginerModel;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table(name = "Product")
public class Product extends SugarRecord {

    String title;

    public Product() {
    }

    public Product(String title) {
        this.title = title;
    }
}
