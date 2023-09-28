package com.example.mad_practical8_21012011032

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {
    companion object{
        val ALARMKEY="Alarm"
        val ALARMSTART="Start"
        val ALARMSTOP="Stop"
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (intent!= null){
            val data=intent.getStringExtra(ALARMKEY)
            if (data!=null){
                val intentservice=Intent(context,AlarmService::class.java)
                if(data==ALARMSTART)
                {
                    context.startService(intentservice)
                }
                else{
                    context.stopService(intentservice)
                }
            }
        }
    }
}