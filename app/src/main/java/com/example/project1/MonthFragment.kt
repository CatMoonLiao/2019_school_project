package com.example.project1

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_month.*

import java.text.SimpleDateFormat
import java.util.*

class MonthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    //calendarView
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_month, container, false)
    }

    override fun onStart() {
        super.onStart()
        initial()
    }


    @SuppressLint("SetTextI18n")
    private fun initial(){
        today.text = calendarView.curMonth.toString()+"月"+calendarView.curDay.toString()+"日"
        todayY.text = calendarView.curYear.toString()
        val cal =Calendar.getInstance()

    }
}

