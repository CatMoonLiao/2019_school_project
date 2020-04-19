package com.example.project1

import java.time.Duration
import java.time.LocalDateTime

data class Event(var name:String, var bgcolor: Int,var hour:Int
                 ,var startdatetime: LocalDateTime,var dur:Duration,var isallday:Boolean)
/*
name:標題
bgcolor:事件顏色
hour:開始的小時(用於timeline分線)
startdatetime:事件開始日期時間
dur:持續時間(minute)
isallday:全天活動
 */