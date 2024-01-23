package com.example.myapplication.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adaptadores.AdapterRecyclerViewAjedrez
import com.example.myapplication.adaptadores.AdapterRecyclerViewPersona
import com.example.myapplication.adaptadores.AdapterRecyclerViewPokemon
import com.example.myapplication.databinding.ActivityActividadSegundoEjercicioBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.interfaces.OnItemClickListenerAjedrez
import com.example.myapplication.modelos.Persona
import com.example.myapplication.modelos.PiezaAjedrez
import com.example.myapplication.modelos.Pokemon

class ActividadSegundoEjercicio : AppCompatActivity() , OnItemClickListenerAjedrez{

    private lateinit var binding: ActivityActividadSegundoEjercicioBinding
    private lateinit var adapterRecyclerViewAjedrez: AdapterRecyclerViewAjedrez

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActividadSegundoEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPiezasAjedrez = mutableListOf(
            PiezaAjedrez(
                imagen = R.drawable.torre,
                nombre = "Torre",
            ),
            PiezaAjedrez(
                imagen = R.drawable.peon,
                nombre = "Peon",
            ),PiezaAjedrez(
                imagen = R.drawable.reina,
                nombre = "Reina",
            ),PiezaAjedrez(
                imagen = R.drawable.rey,
                nombre = "Rey",
            )
        )

        //adapterRecyclerView = AdapterRecyclerView(listaPersonas): Se crea una instancia del adaptador
        //personalizado AdapterRecyclerView, que se espera que tenga una lista de objetos
        //Persona (listaPersonas) como su conjunto de datos.
        adapterRecyclerViewAjedrez = AdapterRecyclerViewAjedrez(listaPiezasAjedrez, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@ActividadSegundoEjercicio, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterRecyclerViewAjedrez
        }
    }

    override fun onItemClick(pieza: PiezaAjedrez) {

    }
}