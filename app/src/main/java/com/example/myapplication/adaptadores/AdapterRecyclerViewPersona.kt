package com.example.myapplication.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemUserBinding
import com.example.myapplication.interfaces.OnItemClickListenerPersona
import com.example.myapplication.modelos.Persona

class AdapterRecyclerViewPersona(private var listaUsuarios: MutableList<Persona>, private val itemClickListener: OnItemClickListenerPersona): RecyclerView.Adapter<AdapterRecyclerViewPersona.ViewHolder>()  {
    //onCreateViewHolder: Se llama cuando se necesita crear un nuevo ViewHolder. En este método, se
    //infla el diseño (R.layout.item_user) utilizando LayoutInflater para convertir el diseño XML en
    //una vista (View). Luego, se crea y devuelve una instancia de ViewHolder que contiene esa vista.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRecyclerViewPersona.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }
    //onBindViewHolder: Se llama para asociar datos a una vista específica en una posición específica.
    //Aquí, se obtiene el ViewHolder correspondiente y se llama al método bind del ViewHolder, pasando
    //la Persona en la posición actual.
    override fun onBindViewHolder(holder: AdapterRecyclerViewPersona.ViewHolder, position: Int) {
        val itemUsuarioActual = listaUsuarios[position]

        holder.bind(itemUsuarioActual)

        holder.setListener(itemUsuarioActual)
    }
    //getItemCount: Devuelve el número total de elementos en el conjunto de datos (en este caso, la lista de usuarios).
    override fun getItemCount(): Int = listaUsuarios.size
    //ViewHolder: Es una clase interna que extiende RecyclerView.ViewHolder. Su propósito es contener
    //y gestionar las vistas de un elemento individual en el RecyclerView.
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        val binding = ItemUserBinding.bind(view)

        fun setListener(persona: Persona){
            binding.root.setOnLongClickListener {
                itemClickListener.onLongItemClick(persona)
                true
            }
        }

        init {
            view.setOnClickListener(this)
        }

        fun bind(persona: Persona){
            binding.tvNombre.text = persona.nombre
            binding.tvCorreo.text = persona.correo
            binding.tvNumeroTelefono.text = persona.telefono
            persona.imagen?.let { binding.ivFotoPersona.setImageResource(it) }
        }

        override fun onClick(v: View) {
            val posicion: Int = adapterPosition
            val persona: Persona = listaUsuarios[posicion]
            itemClickListener.onItemClick(persona)
        }
    }

    fun eliminarPersona(persona: Persona) {
        listaUsuarios.remove(persona)
        notifyDataSetChanged()
    }
}