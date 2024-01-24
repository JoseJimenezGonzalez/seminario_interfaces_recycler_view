package com.example.myapplication.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adaptadores.AdapterRecyclerViewPokemon
import com.example.myapplication.adaptadores.AdapterRecyclerViewPokemonOtro
import com.example.myapplication.databinding.ActivityActividadCuartoEjercicioBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.interfaces.OnItemClickListenerPokemonOtro
import com.example.myapplication.modelos.Pokemon
import com.example.myapplication.modelos.PokemonOtro

class ActividadCuartoEjercicio : AppCompatActivity(), OnItemClickListenerPokemonOtro {

    private lateinit var binding: ActivityActividadCuartoEjercicioBinding

    private lateinit var adapterRecyclerView: AdapterRecyclerViewPokemonOtro
    val listaPokemon = mutableListOf(
        PokemonOtro("Pikachu"),
        PokemonOtro("Raichu"),
        PokemonOtro("Charizard"),
        PokemonOtro("Latios"),
        PokemonOtro("Groudon"),
        PokemonOtro("Rayquaza"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActividadCuartoEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapterRecyclerView = AdapterRecyclerViewPokemonOtro(listaPokemon, this)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@ActividadCuartoEjercicio)
            adapter = adapterRecyclerView
        }

        binding.ivAgregar.setOnClickListener {
            val nombrePokemon = binding.etNombrePokemonAgregar.text.toString().trim().capitalize()
            if(nombrePokemon == ""){
                Toast.makeText(this, "Introduce nombre del pokemon", Toast.LENGTH_LONG).show()
            }else{
                val pokemon = PokemonOtro(nombrePokemon)
                listaPokemon.add(pokemon)
                adapterRecyclerView.notifyDataSetChanged()
                binding.etNombrePokemonAgregar.setText("")
            }
        }


    }

    override fun onItemClick(pokemon: PokemonOtro) {
        listaPokemon.remove(pokemon)
        adapterRecyclerView.notifyDataSetChanged()
    }
}