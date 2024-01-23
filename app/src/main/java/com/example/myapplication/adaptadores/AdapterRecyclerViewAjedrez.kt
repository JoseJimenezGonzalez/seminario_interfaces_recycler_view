package com.example.myapplication.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemAjedrezBinding
import com.example.myapplication.databinding.ItemPokemonBinding
import com.example.myapplication.interfaces.OnItemClickListenerAjedrez
import com.example.myapplication.modelos.PiezaAjedrez

class AdapterRecyclerViewAjedrez(private var listaPiezasAjedrez: MutableList<PiezaAjedrez>, private val itemClickListener: OnItemClickListenerAjedrez): RecyclerView.Adapter<AdapterRecyclerViewAjedrez.ViewHolder>() {
    //onCreateViewHolder: Se llama cuando se necesita crear un nuevo ViewHolder. En este método, se
    //infla el diseño (R.layout.item_user) utilizando LayoutInflater para convertir el diseño XML en
    //una vista (View). Luego, se crea y devuelve una instancia de ViewHolder que contiene esa vista.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRecyclerViewAjedrez.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ajedrez, parent, false)
        return ViewHolder(view)
    }
    //onBindViewHolder: Se llama para asociar datos a una vista específica en una posición específica.
    //Aquí, se obtiene el ViewHolder correspondiente y se llama al método bind del ViewHolder, pasando
    //la Persona en la posición actual.
    override fun onBindViewHolder(holder: AdapterRecyclerViewAjedrez.ViewHolder, position: Int) {
        val itemPokemonActual = listaPiezasAjedrez[position]

        holder.bind(itemPokemonActual)

    }
    //getItemCount: Devuelve el número total de elementos en el conjunto de datos (en este caso, la lista de usuarios).
    override fun getItemCount(): Int = listaPiezasAjedrez.size
    //ViewHolder: Es una clase interna que extiende RecyclerView.ViewHolder. Su propósito es contener
    //y gestionar las vistas de un elemento individual en el RecyclerView.
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        val binding = ItemAjedrezBinding.bind(view)

        init {
            view.setOnClickListener(this)
        }

        fun bind(piezaAjedrez: PiezaAjedrez){
            piezaAjedrez.imagen?.let { binding.imageView.setImageResource(it) }
            binding.textView.text = piezaAjedrez.nombre
        }

        override fun onClick(v: View) {
            val posicion: Int = adapterPosition
            val piezaAjedrez = listaPiezasAjedrez[posicion]
            itemClickListener.onItemClick(piezaAjedrez)
        }
    }
}