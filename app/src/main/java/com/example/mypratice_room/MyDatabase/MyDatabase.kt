package com.example.mypratice_room.MyDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MyJsonClass::class), version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun myDao(): MyDao

    companion object{
        private var instance: MyDatabase ?= null
        fun getInstance(context: Context): MyDatabase?{
            if(instance == null){
                instance = Room.databaseBuilder(context, MyDatabase::class.java, "MyJsonDatabase").build()
            }
            return instance
        }
    }
}