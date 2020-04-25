package com.example.project1

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.tag_item.view.*

class TagAdapter(val layout:Int,var tagList:MutableList<String>) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view=View.inflate(p2?.context,layout,null)
        view.tag_txt.text=tagList[p0]
        return view
    }

    override fun getItem(p0: Int): Any = tagList[p0]


    override fun getItemId(p0: Int): Long =0L


    override fun getCount(): Int =tagList.size

    fun refresh(list:MutableList<String>){
        tagList=list
        notifyDataSetChanged()
    }
}