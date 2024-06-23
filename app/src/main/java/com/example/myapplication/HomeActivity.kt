package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.R.id.itshome
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.network.MarsAdapter
import com.example.myapplication.network.MarsApi
import com.example.myapplication.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    //lateinit var recyclerview: RecyclerView
    lateinit var listMarsPhotos:List<MarsPhoto>
    lateinit var marsAdapter: MarsAdapter
    //lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //imageView = findViewById(R.id.imageView)
        //recyclerview = findViewById(R.id.recyclerView)
        //recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        listMarsPhotos = ArrayList<MarsPhoto>()
        marsAdapter = MarsAdapter(listMarsPhotos)
        //recyclerview.adapter = marsAdapter
        binding.recyclerView.adapter = marsAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var data = intent.extras?.getString("nkey")
        Log.i("HomeActivity","data is = "+data)

        //val homeTextView:TextView = findViewById(itshome)
        //homeTextView.setText(data)
        binding.itshome.setText(data)
    }

    override fun onStart() {
        super.onStart()
        //the below can be in onCreate itself
        binding.btnGet.setOnClickListener{
            getMarsPhotos()
        }
    }

    /*fun getJson(view: View) {
        getMarsPhotos()
    }*/

    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
            //doing time taking tasks on the main thread is not advisable

            val listMarsPhoto = MarsApi.retrofitService.getPhotos()
            //listMarsPhotos = listMarsPhoto
            marsAdapter.listMarsPhotos = listMarsPhoto
            //imageView.load(listMarsPhoto.get(0).imgSrc)
            marsAdapter.notifyItemRangeChanged(0,listMarsPhoto.size)
            Log.i("HomeActivity-1st imgsrc",listMarsPhoto.get(0).imgSrc)
        }
    }
}