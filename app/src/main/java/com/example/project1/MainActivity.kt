package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.month_activity_home)
        val calender = Calendar.getInstance(TimeZone.getDefault(),Locale.TAIWAN)
    }
}
