package com.example.mytour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTours: RecyclerView
    private var list = ArrayList<Tour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTours = findViewById(R.id.rvTours)
        rvTours.setHasFixedSize(true)


        list.addAll(listTours)
        showRecyclerView()
    }


    private val listTours: ArrayList<Tour>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

            val dataList = ArrayList<Tour>()

            for(i in dataName.indices){
                val tour = Tour(
                    dataName[i],
                    dataDescription[i],
                    dataPhoto.getResourceId(i, -1)
                )
                dataList.add(tour)
            }
            return dataList

        }
    fun showRecyclerView(){
        rvTours.layoutManager = LinearLayoutManager(this)
        rvTours.adapter = TourListAdapter(list)
    }
}