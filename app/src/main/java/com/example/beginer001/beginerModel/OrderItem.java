package com.example.beginer001.beginerModel;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;
import java.util.List;

@Table(name="t_order_item")
public class OrderItem extends SugarRecord {

    private int orderId;
    public float itemPrice;
    public int quantity;

    public OrderItem() {
    }

    public OrderItem(int orderId, float itemPrice, int quantity) {
        this.orderId = orderId;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public static List<OrderItem> ListByOrderId(int orderId) {
        return SugarRecord.find(OrderItem.class, "order_id = ?", Integer.toString(orderId));
    }
}
