package com.example.beginer001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.beginer001.beginerModel.Order
import com.example.beginer001.beginerModel.OrderItem
import com.example.beginer001.beginerModel.Product
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.activity_main_list_view.*
import java.util.*

class MainListViewActivity : AppCompatActivity() {

    var ordersList: MutableList<List> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list_view)

        addOrder.setOnClickListener {
            val order = Order()
            order.save()
        }

        getOrder.setOnClickListener {
            val orderList = SugarRecord.listAll(Order::class.java)
            ordersListListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, orderList)
        }


        val list = listOf<String>("Optovik 1", "Optovik 2")

        var list1 = List()
        list1.addListItem(ListItem(200, 3))

        var list2 = List()
        list2.addListItem(ListItem(300, 1))

        ordersList.add(list1)
        ordersList.add(list2)

        val context = this

        ordersListListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        ordersListListView.setOnItemClickListener {_, _, position, _ ->
            val t = MainActivity.newIntent(context, position)
            startActivity(t)
        }
    }
}
