package com.example.myapplication.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adaptadores.AdapterRecyclerViewPokemon
import com.example.myapplication.databinding.ActivityActividadPrimerEjercicio1Binding
import com.example.myapplication.databinding.ActivityActividadTercerEjercicioBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.interfaces.OnItemClickListenerPokemon
import com.example.myapplication.modelos.Pokemon

class ActividadTercerEjercicio : AppCompatActivity(), OnItemClickListenerPokemon {

    private lateinit var binding: ActivityActividadTercerEjercicioBinding

    private lateinit var adapterRecyclerViewCapturados: AdapterRecyclerViewPokemon
    private lateinit var adapterRecyclerViewNoCapturados: AdapterRecyclerViewPokemon
    private lateinit var listaPokemonCapturados: MutableList<Pokemon>
    private lateinit var listaPokemonNoCapturados: MutableList<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActividadTercerEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPokemon = mutableListOf(
            Pokemon("Pikachu", false),
            Pokemon("Raichu", false),
            Pokemon("Chicorita", false),
            Pokemon("Tyranitar", false),
            Pokemon("Bulbasur", false),
            Pokemon("Ivysur", false),
            Pokemon("Charmander", false),
            Pokemon("Polygon", false),
            Pokemon("Ditto", false),
            Pokemon("Nidoran", false),
            Pokemon("Shelgon", false),
            Pokemon("Articuno", false),
            Pokemon("Moltres", false),
            Pokemon("Zapdos", false),
            Pokemon("Entei", false),
        )

        listaPokemonCapturados = mutableListOf<Pokemon>()
        listaPokemonNoCapturados = mutableListOf<Pokemon>()
        listaPokemon.forEach { pokemon ->
            if(pokemon.capturado){
                listaPokemonCapturados.add(pokemon)
            }else{
                listaPokemonNoCapturados.add(pokemon)
            }
        }

        adapterRecyclerViewCapturados = AdapterRecyclerViewPokemon(listaPokemonCapturados, this)
        adapterRecyclerViewNoCapturados = AdapterRecyclerViewPokemon(listaPokemonNoCapturados, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rvCapturados.apply {
            layoutManager = LinearLayoutManager(this@ActividadTercerEjercicio)
            adapter = adapterRecyclerViewCapturados
        }

        binding.rvNoCapturados.apply {
            layoutManager = LinearLayoutManager(this@ActividadTercerEjercicio)
            adapter = adapterRecyclerViewNoCapturados
        }

        binding.ivAgregar.setOnClickListener {
            val nombrePokemon = binding.etNombrePokemonAgregar.text.toString().trim().capitalize()
            if(nombrePokemon == ""){
                Toast.makeText(this, "Introduce nombre del pokemon", Toast.LENGTH_LONG).show()
            }else{
                val estaCapturado = false
                val pokemon = Pokemon(nombrePokemon, estaCapturado)
                listaPokemonNoCapturados.add(pokemon)
                adapterRecyclerViewNoCapturados.notifyDataSetChanged()
                binding.etNombrePokemonAgregar.setText("")
            }
        }
    }

    override fun onItemClick(pokemon: Pokemon) {

        val estaCapturado = pokemon.capturado

        if (estaCapturado) {
            pokemon.capturado = false
            listaPokemonCapturados.remove(pokemon)
            listaPokemonNoCapturados.add(pokemon)
            adapterRecyclerViewCapturados.notifyDataSetChanged()
            adapterRecyclerViewNoCapturados.notifyDataSetChanged()
        } else {
            pokemon.capturado = true
            listaPokemonCapturados.add(pokemon)
            listaPokemonNoCapturados.remove(pokemon)
            adapterRecyclerViewNoCapturados.notifyDataSetChanged()
            adapterRecyclerViewCapturados.notifyDataSetChanged()
        }
    }
}