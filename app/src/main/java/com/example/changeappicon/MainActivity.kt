package com.example.changeappicon

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var oldIconButton :Button
    lateinit var newIconButton :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oldIconButton = findViewById(R.id.oldIcon)
        newIconButton = findViewById(R.id.RamadanIcon)


        Toast.makeText(this,"The Current Date is : ${getCurrentDate()}",Toast.LENGTH_LONG).show()


         val ramadanDate = "2022-03-15T16:00:00.000"
        if(getCurrentDate()==ramadanDate){
            hideOldIcon()
            showNewIcon()

        }

        oldIconButton.setOnClickListener {

        }


        newIconButton.setOnClickListener {
            hideOldIcon()
            showNewIcon()

        }

    }



    private fun hideOldIcon() {
        val packageManager = (packageManager).apply {
            setComponentEnabledSetting(
                ComponentName("com.example.changeappicon","com.example.changeappicon.MainActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        }
    }
    private fun showNewIcon() {
        val packageManager = (packageManager).apply {
            setComponentEnabledSetting(
                ComponentName("com.example.changeappicon","com.example.changeappicon.MainActivityAlias"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )
        }
    }



    fun getCurrentDate():String{
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        return sdf.format(Date())
    }



}