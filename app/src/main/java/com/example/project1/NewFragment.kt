package com.example.project1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.BaseAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_new.*
import java.util.*
//TODO:預設填入現在時間、關掉鍵盤
class NewFragment : Fragment() {
    private var isallday=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onStart() {
        super.onStart()
        val res: Resources = resources
        val colorName = res.getStringArray(R.array.color_name)
        val backgroundColor=res.getIntArray(R.array.item_color)
        color_spinner.adapter= context?.let { ColorAdapter(it,colorName,backgroundColor) }
        //隱藏輸入鍵盤????
        starttime.hideKeyboard()
        endtime.hideKeyboard()
        allday_switch.setOnCheckedChangeListener { _, isChecked ->
            isallday = isChecked
        }
        starttime.setOnClickListener(listener1)
        endtime.setOnClickListener(listener2)
    }


    private var listener1=object :View.OnClickListener{
        override fun onClick(v: View?) {
            var input:String=""
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = context?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                        val m = monthOfYear + 1
                        // Display Selected date in textbox

                        input = "$year/$m/$dayOfMonth"
                        starttime.setText(input)
                        Log.e("day", input)

                        //call time picker
                        if(!isallday){
                            val hour = c.get(Calendar.HOUR)
                            val minute = c.get(Calendar.MINUTE)
                            val timePickerDialog=TimePickerDialog(
                                it,
                                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                                    var h="$hourOfDay"
                                    var min="$minute"
                                    if(hourOfDay<10){
                                        h="0$hourOfDay"
                                    }
                                    if(minute<10){
                                        min="0$minute"
                                    }
                                    input+=" $h:$min"
                                    starttime.setText(input)
                                },
                                hour,
                                minute,
                                false
                            )
                            timePickerDialog.show()
                        }
                    },
                    year,
                    month,
                    day
                )
            }
            dpd?.show()
        }
    }

    private var listener2=object :View.OnClickListener{
        override fun onClick(v: View?) {
            var input:String=""
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = context?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        val m = monthOfYear + 1
                        // Display Selected date in textbox
                        input = "$year/$m/$dayOfMonth"
                        endtime.setText(input)

                        //call time picker
                        if(!isallday){
                            val hour = c.get(Calendar.HOUR)
                            val minute = c.get(Calendar.MINUTE)
                            val timePickerDialog=TimePickerDialog(
                                it,
                                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                                    var h="$hourOfDay"
                                    var min="$minute"
                                    if(hourOfDay<10){
                                        h="0$hourOfDay"
                                    }
                                    if(minute<10){
                                        min="0$minute"
                                    }
                                    input+=" $h:$min"
                                    endtime.setText(input)
                                },
                                hour,
                                minute,
                                false
                            )
                            timePickerDialog.show()
                        }
                    },
                    year,
                    month,
                    day
                )
            }
            dpd?.show()
        }
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
