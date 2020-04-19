package com.example.project1


import android.graphics.Color
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class DayEvent(val date:LocalDate) {
    var eventList:MutableList<Event> = mutableListOf()

    init {

        val duration:Duration= Duration.ofMinutes(15)

        var temphr=0
        var tempmin=0
        for(i in 0..95){
            tempmin=(i*15)%60
            temphr=(i*15)/60
            var tempTime=LocalTime.of(temphr,tempmin)
            val emptyEvent=Event("test", Color.WHITE, temphr,
                LocalDateTime.of(date, tempTime), duration,false)
            emptyEvent.name=tempTime.toString()
            eventList.add(emptyEvent)
        }
    }

}