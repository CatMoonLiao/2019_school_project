package com.example.project1

import com.example.project1.R.layout.color_spinner_item
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ColorAdapter(context: Context, private val colorNames: Array<String>, private val colorList: IntArray) :
    BaseAdapter() {

    private val inflator: LayoutInflater

    init {
        inflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return colorList.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if(convertView==null) {
            convertView = inflator.inflate(color_spinner_item, null)
        }
        val tvColor = convertView?.findViewById<View>(R.id.tv_color) as TextView
        tvColor.text = colorNames[position]
        tvColor.setTextColor(Color.BLACK)
        tvColor.setBackgroundColor(colorList[position])

        return convertView

    }
}
