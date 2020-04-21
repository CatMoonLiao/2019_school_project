package com.example.project1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView
import kotlinx.android.synthetic.main.fragment_week.*
import xyz.sangcomz.stickytimelineview.RecyclerSectionItemDecoration
import xyz.sangcomz.stickytimelineview.model.SectionInfo
import java.time.LocalDate

class WeekFragment : Fragment() {
    lateinit var eventList:MutableList<Event>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week, container, false)
    }

    override fun onStart() {
        super.onStart()

        //select day
        calendarView.setOnCalendarSelectListener(selectdaylistener)
        //initial text
        today.text=calendarView.curMonth.toString()+"月"+calendarView.curDay.toString()+"日"
        year.text=calendarView.curYear.toString()



        /*TIME LINE*/
        recycler_view.layoutManager = LinearLayoutManager(this.context,
            RecyclerView.VERTICAL,
            false)

        //Get today data
        eventList = getEventList(LocalDate.now())


       // Add RecyclerSectionItemDecoration.SectionCallback
        recycler_view.addItemDecoration(getSectionCallback(eventList))

        //Set Adapter
        recycler_view.adapter = TimeLineAdapter(layoutInflater,
            eventList,
            R.layout.event_item)

    }

    public fun getEventList(date:LocalDate):MutableList<Event>{
        //從資料庫取得event list
        return DayEvent(LocalDate.now()).eventList
    }


    private val selectdaylistener=object:CalendarView.OnCalendarSelectListener{
        override fun onCalendarOutOfRange(calendar: Calendar?) {
        }

        @SuppressLint("SetTextI18n")
        override fun onCalendarSelect(calendar: Calendar, isClick: Boolean) {
            //選擇日期修改畫面
            val date=LocalDate.of(calendar.year,calendar.month,calendar.day)

            //修改上側日期顯示
            today.text=calendar.month.toString()+"月"+calendar.day+"日"
            year.text=calendar.year.toString()
            //強制刷新timeline
            val temp=getEventList(date)
            eventList.clear()
            eventList.addAll(temp)
            recycler_view.adapter!!.notifyDataSetChanged()
        }

    }




    //timeline
    //Get SectionCallback method
    private fun getSectionCallback(TodayList: List<Event>): RecyclerSectionItemDecoration.SectionCallback {
        return object : RecyclerSectionItemDecoration.SectionCallback {

            //In your data, implement a method to determine if this is a section.
            override fun isSection(position: Int): Boolean {
                var temp=position-1
                if(temp<0)
                    return true
                return eventList[position].hour!=eventList[temp].hour
            }

            //Implement a method that returns a SectionHeader.
            override fun getSectionHeader(position: Int): SectionInfo? {

                return SectionInfo(eventList[position].hour.toString()+":00"
                    ,eventList[position].startdatetime.dayOfWeek.toString())

            }
        }
    }


}
