package com.example.beginer001

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.cart_list_item_view.view.*

class CartListViewAdapter(private val context: Context,
                          private val dataSource: List) : BaseAdapter() {


    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.cart_list_item_view, parent, false)

        val currentItem = getItem(position)

        rowView.titleTextView.text = "Наименование товара"
        rowView.quantityTextView.text = currentItem.quantity.toString()
        rowView.priceTextView.text = currentItem.price.toString()
        rowView.lineTotalTextView.text = currentItem.lineTotal.toString()

        if(position == dataSource.selectedIndex) {
            rowView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            rowView.background.alpha = 30
        }

        return rowView
    }

    override fun getItem(position: Int): ListItem {
        return dataSource.listItem[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.listItem.size
    }

}