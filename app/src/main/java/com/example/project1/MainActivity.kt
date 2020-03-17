package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    val transaction = supportFragmentManager.beginTransaction()

    public var listener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.menu_month -> {
                    Log.e("month","!!!")
                    transaction.replace(R.id.frameLayout, MonthFragment()).commit()
                    return true
                }
                R.id.menu_week -> {
                    transaction.replace(R.id.frameLayout, WeekFragment()).commit()
                    return true
                }
                R.id.menu_day -> {
                    transaction.replace(R.id.frameLayout, DayFragment()).commit()
                    return true
                }
                R.id.menu_new -> {
                    transaction.replace(R.id.frameLayout, NewFragment()).commit()
                    return true
                }
                R.id.menu_note -> {
                    transaction.replace(R.id.frameLayout, NoteFragment()).commit()
                    return true
                }
            }
            return false
        }
   }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
         //預設葉面
        transaction.replace(R.id.frameLayout, DayFragment()).commit()

        //menu listener
        var menubtn=findViewById<BottomNavigationView>(R.id.menu_btn)
        menubtn.setOnNavigationItemSelectedListener(listener)



        val calender = Calendar.getInstance(TimeZone.getDefault(),Locale.TAIWAN)
    }


}
