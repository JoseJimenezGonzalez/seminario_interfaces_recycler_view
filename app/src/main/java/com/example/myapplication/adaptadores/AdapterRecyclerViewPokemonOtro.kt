package com.example.myapplication.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemPokemonBinding
import com.example.myapplication.databinding.ItemPokemonOtroBinding
import com.example.myapplication.interfaces.OnItemClickListenerPokemon
import com.example.myapplication.interfaces.OnItemClickListenerPokemonOtro
import com.example.myapplication.modelos.Pokemon
import com.example.myapplication.modelos.PokemonOtro

class AdapterRecyclerViewPokemonOtro(private var listaPokemons: MutableList<PokemonOtro>, private val itemClickListener: OnItemClickListenerPokemonOtro): RecyclerView.Adapter<AdapterRecyclerViewPokemonOtro.ViewHolder>()  {

    //onCreateViewHolder: Se llama cuando se necesita crear un nuevo ViewHolder. En este método, se
    //infla el diseño (R.layout.item_user) utilizando LayoutInflater para convertir el diseño XML en
    //una vista (View). Luego, se crea y devuelve una instancia de ViewHolder que contiene esa vista.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRecyclerViewPokemonOtro.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_otro, parent, false)
        return ViewHolder(view)
    }
    //onBindViewHolder: Se llama para asociar datos a una vista específica en una posición específica.
    //Aquí, se obtiene el ViewHolder correspondiente y se llama al método bind del ViewHolder, pasando
    //la Persona en la posición actual.
    override fun onBindViewHolder(holder: AdapterRecyclerViewPokemonOtro.ViewHolder, position: Int) {
        val itemPokemonActual = listaPokemons[position]

        holder.bind(itemPokemonActual)

    }
    //getItemCount: Devuelve el número total de elementos en el conjunto de datos (en este caso, la lista de usuarios).
    override fun getItemCount(): Int = listaPokemons.size
    //ViewHolder: Es una clase interna que extiende RecyclerView.ViewHolder. Su propósito es contener
    //y gestionar las vistas de un elemento individual en el RecyclerView.
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        val binding = ItemPokemonOtroBinding.bind(view)

        init {
            view.setOnClickListener(this)
        }

        fun bind(pokemon: PokemonOtro){
            binding.tvNombrePokemon.text = pokemon.nombre
        }

        override fun onClick(v: View) {
            val posicion: Int = adapterPosition
            val pokemon: PokemonOtro = listaPokemons[posicion]
            itemClickListener.onItemClick(pokemon)
        }
    }

}