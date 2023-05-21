package com.kotlinegitim.hw4_kotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var newList : ListView
    var listNew = mutableListOf<New>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       newList = findViewById(R.id.newsList)

        var act : Activity = this


        val result = NewContent()


        Thread(Runnable {

            val list = result.news()
            listNew = list as MutableList<New>


            this@MainActivity.runOnUiThread(java.lang.Runnable {


                val adapter = NewListView(this,R.layout.new_custom_layout, listNew)

                newList.adapter = adapter
            })
        }).start()






    }


}

