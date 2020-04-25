package com.example.project1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_allnote.*

class AllNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allnote)
        //getSupportActionBar()?.hide()

        back_btn2.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
