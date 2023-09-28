package com.example.mad_practical8_21012011032

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import java.util.Calendar

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardView = findViewById<MaterialCardView>(R.id.card2)
        cardView.visibility=View.GONE
        val createAlarm = findViewById<MaterialButton>(R.id.button_Alarm)
        createAlarm.setOnClickListener{
            //cardView.visibility=View.VISIBLE
            TimePickerDialog(this, { tp, hour, minute -> setAlarmTime(hour, minute) },Calendar.HOUR, Calendar.MINUTE,false).show()
        }
    }
    fun setAlarmTime(hour:Int,minute:Int)
    {
        val cardView=findViewById<MaterialCardView>(R.id.card2)
        cardView.visibility=View.GONE
        val alarmtime=Calendar.getInstance()
        val year=alarmtime.get(Calendar.YEAR)
        val month=alarmtime.get(Calendar.MONTH)
        val date=alarmtime.get(Calendar.DATE)
        alarmtime.set(year, month, date, hour, minute)
        setAlarm(alarmtime.timeInMillis,AlarmBroadcastReceiver.ALARMSTART)
        //cardView.visibility=View.GONE
    }


    fun stop()
    {
        setAlarm(-1,AlarmBroadcastReceiver.ALARMSTOP)
    }

    fun setAlarm(millitime:Long,action:String)
    {
        val intentalarm=Intent(applicationContext,AlarmBroadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBroadcastReceiver.ALARMKEY,action)
        val pendingintent=PendingIntent.getBroadcast(applicationContext,4356,intentalarm,PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmmanager=getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==AlarmBroadcastReceiver.ALARMSTART){
            alarmmanager.setExact(AlarmManager.RTC_WAKEUP,millitime,pendingintent)
        }
        else if(action==AlarmBroadcastReceiver.ALARMSTOP)
            alarmmanager.cancel(pendingintent)
        sendBroadcast(intentalarm)

    }
}