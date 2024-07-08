package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R.id.itshome
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

    }

    override fun onStart() {
        super.onStart()
        var view: ConstraintLayout = findViewById(R.id.main)
        Snackbar.make(view,"sending sms wishes",Snackbar.LENGTH_LONG).setAction("stop sending",
            View.OnClickListener {  }).show()

        /*val smsManager: SmsManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.getSystemService(SmsManager::class.java)
        } else {
            SmsManager.getDefault()
        }

        val smsManager:SmsManager = SmsManager.getDefault()
        smsManager.sendTextMessage("9880979732",null,"happy day",null,null)*/
    }
}