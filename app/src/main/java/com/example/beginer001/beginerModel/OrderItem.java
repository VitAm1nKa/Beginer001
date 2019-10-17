package com.example.beginer001.beginerModel;

import com.orm.SugarRecord;

import java.util.Date;

public class OrderItem extends SugarRecord {

    public int getOrderId() {
        return orderId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    private int orderId;

    float itemPrice;
    int quantity;

    private Date dateAdded = new Date();
    private Date dateModified = new Date();

    public OrderItem() {
    }

    public OrderItem(float itemPrice, int quantity) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }
}
