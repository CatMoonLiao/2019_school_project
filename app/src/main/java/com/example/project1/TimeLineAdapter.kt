package com.example.project1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class TimeLineAdapter(private val layoutInflater: LayoutInflater,
                      private val eventList: MutableList<Event>,
                      @param:LayoutRes private val itemLayout: Int):RecyclerView.Adapter<TimeLineAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = layoutInflater.inflate(itemLayout, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = eventList[position]
        holder.target.text = position.toString()
    }

    override fun getItemCount(): Int = eventList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val target: TextView = view.findViewById<View>(R.id.target) as TextView
    }

}