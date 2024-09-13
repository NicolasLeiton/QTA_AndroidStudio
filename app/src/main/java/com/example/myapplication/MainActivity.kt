package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextInput: EditText = findViewById(R.id.entrada)

        val botonCelcius: Button = findViewById(R.id.celcius)
        val botonFar: Button = findViewById(R.id.Farenhiet)
        val botonkelvin: Button = findViewById(R.id.Kelvin)

        val TextCelcius: TextView = findViewById(R.id.txtC)
        val TextFar: TextView = findViewById(R.id.txtF)
        val TextKelvin: TextView = findViewById(R.id.txtK)


        // Configurar el listener del botón
        botonCelcius.setOnClickListener {
            // Obtener el texto del EditText
            val inputText: String = editTextInput.text.toString()
            val numero: Float = inputText.toFloat()
            TextCelcius.text= (inputText)
            TextFar.text= (numero*9/5 + 32).toString()
            TextKelvin.text= (numero+ 273.15).toString()
            }

        botonFar.setOnClickListener {
            // Obtener el texto del EditText
            val inputText: String = editTextInput.text.toString()
            val numero: Float = inputText.toFloat()
            TextFar.text= (inputText)
            TextCelcius.text= String.format("%.2f", ((numero - 32) * 5/9))
            TextKelvin.text= String.format("%.2f", ((numero - 32) * 5/9 + 273.15))
            }
        botonkelvin.setOnClickListener {
            // Obtener el texto del EditText
            val inputText: String = editTextInput.text.toString()
            val numero: Float = inputText.toFloat()
            TextKelvin.text= (inputText)
            TextCelcius.text=  String.format("%.2f", (numero - 273.15))
            TextFar.text= String.format("%.2f", ((numero - 273.15) * 9/5 + 32))
        }
    }



}