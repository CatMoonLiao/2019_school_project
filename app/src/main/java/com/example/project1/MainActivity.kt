package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    private var listener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.menu_month -> {
                    val transaction = manager.beginTransaction()

                    transaction.replace(R.id.frameLayout, MonthFragment()).commit()
                    return true
                }
                R.id.menu_week -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, WeekFragment()).commit()
                    return true
                }
                R.id.menu_day -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, DayFragment()).commit()
                    return true
                }
                R.id.menu_new -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, NewFragment()).commit()
                    return true
                }
                R.id.menu_note -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, NoteFragment()).commit()
                    return true
                }
            }
            return false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.setting, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting_btn) {
            //切換頁面
            return super.onOptionsItemSelected(item)
        }
        return false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        getSupportActionBar()?.hide() //隱藏標題
        // 隱藏狀態
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN)
        val transaction = manager.beginTransaction()
        //預設葉面

        transaction.replace(R.id.frameLayout, DayFragment()).commit()

        //menu listener
        val menubtn=findViewById<BottomNavigationView>(R.id.menu_btn)
        menubtn.setOnNavigationItemSelectedListener(listener)
        menubtn.setSelectedItemId(R.id.menu_day)


      //  val calender = Calendar.getInstance(TimeZone.getDefault(),Locale.TAIWAN)
    }


}
