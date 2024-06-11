package com.example.uomodelmachineri

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uomodelmachineri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    val historyEntries = mutableListOf<Float>()

    fun addEntryToHistory(entry: Float) {
        // If the list already has 20 items, remove the oldest one
        if (historyEntries.size == 20) {
            historyEntries.removeAt(0)
        }
        // Add the new entry to the list
        historyEntries.add(entry)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnHistory.setOnClickListener()
        {
            val intent = Intent(this, SecondaryActivity::class.java)

            val floatArray = historyEntries.toFloatArray()

            intent.putExtra("history_key", floatArray)

            startActivity(intent)
        }

        binding.btnCalculate.setOnClickListener()
        {
            var a : Float
            var b : Float

            a = binding.TBA.text.toString().toFloat()
            b = binding.TBB.text.toString().toFloat()

            var c : Float = a+b


            addEntryToHistory(c)

            Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show()
        }


    }
}
