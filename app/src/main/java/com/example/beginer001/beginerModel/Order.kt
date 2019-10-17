package com.example.beginer001.beginerModel

import com.orm.SugarRecord
import com.orm.dsl.Table

@Table(name = "t_order")
class Order: SugarRecord() {

    fun AddOrderItem(orderItem: OrderItem): OrderItem {
        return orderItem
    }

    fun UpdateOrderItem(orderItem: OrderItem): OrderItem {
        return orderItem
    }

    fun RemoveOrderItem(orderItem: OrderItem): Boolean {
        return true
    }

    override fun toString(): String {
        return "Order #${id}: "
    }


}