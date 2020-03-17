package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {

    public var listener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.menu_month -> {
                }
                R.id.menu_week -> {
                }
                R.id.menu_day -> {
                }
                R.id.menu_new -> {
                }
                R.id.menu_note -> {
                }
            }
            return true
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        var menubtn=findViewById<BottomNavigationView>(R.id.menu_btn)
        menubtn.setOnNavigationItemSelectedListener(listener)
        val calender = Calendar.getInstance(TimeZone.getDefault(),Locale.TAIWAN)
    }


}
