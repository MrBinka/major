package com.example.kalkbmi

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kalkbmi.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySecondaryBinding

    var historyEntries : FloatArray? = null



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        historyEntries = intent.getFloatArrayExtra("history_key")


        val historyList: List<Float> = historyEntries?.toList() ?: emptyList()

        val listView = findViewById<ListView>(R.id.historyListView)
        val adapter = ArrayAdapter<Float>(this, android.R.layout.simple_list_item_1, historyList)
        listView.adapter = adapter

        binding.btnExit.setOnClickListener()
        {
            finish()
        }

        binding.btnTest.setOnClickListener()
        {


        }


    }
}
