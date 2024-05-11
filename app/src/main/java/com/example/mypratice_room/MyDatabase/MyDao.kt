package com.example.mypratice_room.MyDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(myJsonData: MyJsonClass)

//    @Query("select * from MyJsonClass")
//    fun getAll(): List<MyJsonClass>
}