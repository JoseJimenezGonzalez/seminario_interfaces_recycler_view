package com.example.myapplication.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityActividadSegundoEjercicioBinding
import com.example.myapplication.databinding.ActivityMainBinding

class ActividadSegundoEjercicio : AppCompatActivity() {

    private lateinit var binding: ActivityActividadSegundoEjercicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActividadSegundoEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}