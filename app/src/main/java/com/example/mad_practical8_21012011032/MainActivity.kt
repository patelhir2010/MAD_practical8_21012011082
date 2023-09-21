package com.example.mad_practical8_21012011032

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardView=findViewById<MaterialCardView>(R.id.card2)

        val createAlam=findViewById<MaterialButton>(R.id.button_Alarm)
        createAlam.setOnClickListener{
            //cardView.visibility=View.VISIBLE
            TimePickerDialog(this,{tp,hour,minute->setAlarmtime(hour,minute)},11,0,false).show()
        }
    }
    fun setAlarmtime(hour:Int,minute:Int){
        //cardView.visibility=View.GONE
    }
}