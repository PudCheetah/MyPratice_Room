package com.example.mypratice_room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mypratice_room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var myDataReader = MyDataReader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        CoroutineScope(Dispatchers.Main).launch {
            joinAll(myDataReader.getJob())
            withContext(Dispatchers.IO){
                myDataReader.insertDataToDatabase(this@MainActivity)
            }
            binding.TVMain.text = myDataReader.getmyJsonData().toString()
            setContentView(binding.root)
        }

    }
}