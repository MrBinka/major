package com.example.kalkbmi

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kalkbmi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    val historyEntries = mutableListOf<Float>()

    fun addEntryToHistory(entry: Float) {

        if (historyEntries.size == 20) {
            historyEntries.removeAt(0)
        }
        historyEntries.add(entry)
    }

    fun calcBMI(masa : Float, wzrost : Float) : Float
    {
        return 1.0f
    }



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnHistory.setOnClickListener()
        {
            val intent = Intent(this, SecondaryActivity::class.java)

            val floatArray = historyEntries.toString()

            intent.putExtra("history_key", floatArray)

            startActivity(intent)
        }

        binding.btnCalculate.setOnClickListener()
        {
            val selectedRadioButton = findViewById<RadioButton>(binding.rgAktywnosc.checkedRadioButtonId)

            var cena = 0

           //when (selectedRadioButton.id) {
           //    R.id.radioButton -> cena = 10
           //    R.id.radioButton3 -> cena = 15
           //    R.id.radioButton -> cena = 20
           //    else -> {

           //    }
           //}


            addEntryToHistory(12.0f)

            //Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show()
        }


    }
}



//Messagebox


//val builder = AlertDialog.Builder(this)
//builder.setTitle("Twoje zamówienie:")
//builder.setMessage("Cena: $cena zł")
//
//builder.setPositiveButton("OK") { dialog, which ->
//    // User clicked OK button
//}
//
//val dialog = builder.create()
//dialog.show()




//Toast
//Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show()
