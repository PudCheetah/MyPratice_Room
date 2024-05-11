package com.example.mypratice_room

import android.content.Context
import com.example.mypratice_room.MyDatabase.MyDatabase
import com.example.mypratice_room.MyDatabase.MyJsonClass
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.URL

class MyDataReader{
    private lateinit var myJob: Job
    private lateinit var myJsonData: MyJsonClass

    init {
        myJob = CoroutineScope(Dispatchers.IO).launch {
            var myURL = URL("https://opendata.cwa.gov.tw/api/v1/rest/datastore/E-A0014-001?Authorization=CWA-1394A705-AF6D-4DD6-9D2A-28ABBA9CF3B6&format=JSON").readText()
            myJsonData = Gson().fromJson(myURL, MyJsonClass::class.java)
        }
    }
    fun getJob(): Job{
        return myJob
    }
    fun getmyJsonData(): MyJsonClass?{
        return myJsonData
    }

    fun insertDataToDatabase(context: Context){
        MyDatabase?.getInstance(context)?.myDao()?.insert(myJsonData)
    }
//    fun getDatabaseData(context: Context): List<MyJsonClass>?{
//        return MyDatabase?.getInstance(context)?.myDao()?.getAll()
//    }
}