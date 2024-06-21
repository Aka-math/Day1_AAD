package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //lateinit brake var: Int?
    var TAG = HomeActivity::class.java.simpleName

    var data = arrayOf("india","english","android","computers")

    lateinit var mySpinner: Spinner
    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        mySpinner = findViewById(R.id.spinner)
        mySpinner.onItemSelectedListener = this

        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        var dataAdapter = DataAdapter(data)
        recyclerview.adapter = dataAdapter
        //brake
        /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var data = intent.extras?.getString("nkey")
        Log.i("HomeActivity","data is = "+data)
        val homeTextView:TextView = findViewById(itshome)
        homeTextView.setText(data)  */
    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item = adapter?.selectedItem.toString()
        Log.i(TAG, item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun getShowText(view: View) {
        var uiEt: EditText = findViewById(R.id.etUi)
        var textTyped = uiEt.text.toString()
        var uiTv: TextView = findViewById(R.id.tvUi)
        uiTv.setText(textTyped)
    }


}