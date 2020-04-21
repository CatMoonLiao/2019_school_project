package com.example.project1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haibin.calendarview.CalendarView
import kotlinx.android.synthetic.main.fragment_month.*
import java.time.LocalDate

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
        calendarView.setOnCalendarSelectListener(selectdaylistener)

    }



    private val selectdaylistener=object: CalendarView.OnCalendarSelectListener{
        override fun onCalendarOutOfRange(calendar: com.haibin.calendarview.Calendar?) {
        }

        @SuppressLint("SetTextI18n")
        override fun onCalendarSelect(calendar: com.haibin.calendarview.Calendar, isClick: Boolean) {
            //選擇日期修改畫面
            val date= LocalDate.of(calendar.year,calendar.month,calendar.day)

            //修改上側日期顯示
            today.text=calendar.month.toString()+"月"+calendar.day+"日"
            todayY.text=calendar.year.toString()
            //強制刷新timeline
        }

    }
    @SuppressLint("SetTextI18n")
    private fun initial(){
        today.text = calendarView.curMonth.toString()+"月"+calendarView.curDay.toString()+"日"
        todayY.text = calendarView.curYear.toString()

    }
}

