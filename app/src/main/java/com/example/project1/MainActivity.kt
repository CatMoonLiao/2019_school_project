package com.example.project1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    val weekFragment= WeekFragment()
    val monthFragment= MonthFragment()
    val newFragment= NewFragment()
    val noteFragment= NoteFragment()
    private var listener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.fab->{
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, newFragment).commit()
                    return false
                }
                R.id.menu_month -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, monthFragment).commit()
                    return true
                }
                R.id.menu_week -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, weekFragment).commit()
                    return true
                }

                R.id.menu_note -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(R.id.frameLayout, noteFragment).commit()
                    return true
                }
            }
            return false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide() //隱藏標題

         val transaction = manager.beginTransaction()
        //預設葉面
        transaction.replace(R.id.frameLayout, WeekFragment()).commit()

        //menu listener
        val menubtn=findViewById<BottomNavigationView>(R.id.menu_btn)
        menubtn.setOnNavigationItemSelectedListener(listener)
        menubtn.setSelectedItemId(R.id.menu_week)

        //new button
        fab.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                  val transaction = manager.beginTransaction()
                   transaction.replace(R.id.frameLayout, newFragment).commit()
            }

        })

        //切換到設定
        val settingbtn=findViewById<ImageButton>(R.id.setting_btn)
        settingbtn.setOnClickListener{
            startActivity(Intent(this,SettingActivity::class.java))
        }
    }


}
