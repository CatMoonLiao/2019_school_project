package com.example.project1

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.fragment_note.*
import java.time.LocalDate
import java.util.*

class NoteFragment : Fragment() {
    val itemArray= arrayOf("新增筆記","新增標籤","插入行程","插入文字")
    var tagList= mutableListOf<String>(LocalDate.now().month.value.toString()+"/"+LocalDate.now().dayOfMonth)
    val tagadapter=TagAdapter(R.layout.tag_item,tagList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }


    override fun onStart() {
        super.onStart()
        gridview.adapter= tagadapter

        allnote_btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(Intent(context,AllNoteActivity::class.java))
            }
        })


        insert_btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                AlertDialog.Builder(context).setItems(itemArray){_, which ->
                    when(which){
                        //新增標籤
                        1->newTag()

                    }
                    //do what the button should do

                }.show()
            }

        })

    }

    fun newTag(){
        tagList.add("test")
        tagadapter.refresh(tagList)
    }

}

