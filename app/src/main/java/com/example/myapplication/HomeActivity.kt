package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.database.Item
import com.example.myapplication.database.ItemDao
import com.example.myapplication.database.ItemRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var dao: ItemDao
    lateinit var itshome: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        itshome = findViewById(R.id.itshome)
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
    }

    override fun onStart() {
        super.onStart()
    }

    fun insertDb(view: View) {
        GlobalScope.launch {
            val item = Item(777,"fruits",111.0,22)
            dao.insert(item)
        }
    }

    fun findItemDb(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
            val item = dao.getItem(777).first()
            itshome.setText(item.itemName)
        }
    }
}