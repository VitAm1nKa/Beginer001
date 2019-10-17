package com.example.beginer001

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.min
import kotlin.math.round

class ListItem(var price: Int = 0, var quantity: Int = 1) {
    val lineTotal: Int
        get() = price * quantity

    override fun toString(): String {
        return "Price: $price, Quantity: $quantity"
    }
}

class List {
    var selectedIndex: Int = -1
    val selectedItem: ListItem?
        get() {
            if(selectedIndex != -1 && listItem.size > 0) {
                return listItem[selectedIndex]
            }

            return null
        }

    val modelCount: Int
        get() = listItem.size
    val productsCount: Int
        get() = listItem.sumBy { it.quantity }

    var listItem: MutableList<ListItem> = mutableListOf()

    val subTotal: Int
        get() = listItem.sumBy { i -> i.lineTotal }

    val total: Int
        get() {
            var subTotal = this.subTotal
            if(subTotal > 20000) {
                return (round(subTotal * 0.98 / 5) * 5).toInt()
            }

            return subTotal
        }

    fun addListItem(listItem: ListItem? = null) {
        if(listItem != null) {
            this.listItem.add(listItem)
            this.selectedIndex = this.listItem.size - 1
        }
    }

    fun updateListItem(listItem: ListItem, position: Int? = null) {
        var index: Int = position?.let { position } ?: this.selectedIndex

        this.listItem[index] = listItem
    }

    fun removeListItem(position: Int?) {
        position?.let {
            if(it != -1 && listItem.size > 0) {
                listItem.removeAt(it)
                selectedIndex = min(listItem.size - 1, it)
            }
        }
    }
}

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_LIST = "list"

        fun newIntent(context: Context, listId: Int): Intent {
            var intent = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_LIST, listId)

            return intent
        }
    }

    private var itemList: List = List()
    // private var itemList: MutableList<ListItem> = mutableListOf()
    private var clicks: Int = 0
    private var cartListViewAdapter: CartListViewAdapter? = null
    private var selectedIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cartListViewAdapter = CartListViewAdapter(this, itemList)
        cartListView.adapter = cartListViewAdapter
        cartListView.setOnItemClickListener {_, _, position, _ ->
            itemList.selectedIndex = position
            cartListViewAdapter?.notifyDataSetChanged()
        }

        renderView()
    }

    private fun renderView() {
        subTotalTextView.text = itemList.subTotal.toString()
        totalTextView.text = itemList.total.toString()
        metaTextView.text = "Кол-во моделей: ${itemList.modelCount}\r\nКол-во товаров: ${itemList.productsCount}"
    }

    private fun addListItem(listItem: ListItem) {
        itemList.addListItem(listItem)
        cartListViewAdapter?.notifyDataSetChanged()
        renderView()
    }

    private fun updateListItem(listItem: ListItem, position: Int? = null) {
        itemList.updateListItem(listItem, position)
        cartListViewAdapter?.notifyDataSetChanged()
        renderView()
    }

    private fun removeListItem(position: Int? = null) {
        val index = position?.let { it } ?: itemList.selectedIndex

        itemList.removeListItem(index)
        cartListViewAdapter?.notifyDataSetChanged()
        renderView()

    }

    override fun onClick(v: View?) {
        var code = (v?.tag as String).split("_").toTypedArray()
        var text = operationsTextView.text as String

        if(code[0] == "di") {
            operationsTextView.text = "${text}${code[1]}"
        }

        if(code[0] == "op") {
            when(code[1]) {
                "clear" -> operationsTextView.text = ""
                "add" -> {
                    if(text.isNotEmpty()) {
                        val price = text.toInt()
                        addListItem(ListItem(price))
                        operationsTextView.text = ""
                    }
                }
                "quantity" -> {
                    itemList.selectedItem?.let {
                        if (text.isNotEmpty()) {
                            it.quantity = text.toInt()
                        } else {
                            it.quantity++
                        }

                        updateListItem(it)
                        operationsTextView.text = ""
                    }

                }
                "price" -> {
                    itemList.selectedItem?.let {
                        if(text.isNotEmpty()) {
                            it.price = text.toInt()
                        }

                        updateListItem(it)
                        operationsTextView.text = ""
                    }
                }
                "remove" -> {
                    removeListItem()
                }
            }
        }
    }




}
