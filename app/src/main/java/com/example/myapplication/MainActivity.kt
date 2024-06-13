package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"

    //chick is getting created in the egg  --- memory is being allocated for the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity created -- memory allocations")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //chick has hatched  --- activity is visible for clicks
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity started -- initialize  data")    }

    //chick has woken up -- come back to the foreground
    override fun onResume() {
        super.onResume()
        Log.w(TAG,"activity resumed --restore state of the app")    }

    //chick has slept  --is partially visible -- background
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"activity paused --store the app state")
    }

    //activity hibernated
    override fun onStop() {
        super.onStop()
        Log.v(TAG,"activity stopped")
    }

    //all the resources are purged
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"activity destroyed")
    }

    fun myClickhandler(view: View) {
        Log.i("MainActivity", "button clicked")
        //var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"))
        //var webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        //startActivity(webIntent)

        //createAlarm("its time",19,30)

        var hIntent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("nkey","abdul-android")
        startActivity(hIntent)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        //if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        // }
    }
}