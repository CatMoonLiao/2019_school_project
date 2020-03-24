package com.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        getSupportActionBar()?.hide()

        val backbtn=findViewById<ImageButton>(R.id.back_btn)
        backbtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
