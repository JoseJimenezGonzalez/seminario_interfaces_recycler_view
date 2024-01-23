package com.example.myapplication.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adaptadores.AdapterRecyclerViewPersona
import com.example.myapplication.databinding.ActivityActividadPrimerEjercicio1Binding
import com.example.myapplication.interfaces.OnItemClickListenerPersona
import com.example.myapplication.modelos.Persona

class ActividadPrimerEjercicio1 : AppCompatActivity(), OnItemClickListenerPersona{

    private lateinit var binding: ActivityActividadPrimerEjercicio1Binding
    private lateinit var adapterRecyclerView: AdapterRecyclerViewPersona

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActividadPrimerEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPersonas = mutableListOf(
            Persona(
                imagen = R.drawable.ada_lovelace,
                nombre = "Ada Lovelace",
                correo = "ada@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.stephen_hawking,
                nombre = "Stephen Hawking",
                correo = "hawking@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.sir_isaac_newton,
                nombre = "Sir Isaac Newton",
                correo = "newton@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.gauss,
                nombre = "Friedrich Gauss",
                correo = "gauss@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.alan_turing,
                nombre = "Alan Turing",
                correo = "turing@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.euler,
                nombre = "Leonhard Euler",
                correo = "euler@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.werner_heisenberg,
                nombre = "Werner Heisenberg",
                correo = "heisenberg@gmail.com",
                telefono = "666666666",
            ),

            Persona(
                imagen = R.drawable.nietzsche,
                nombre = "Nietzsche",
                correo = "nietzsche@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.javier_santaolalla,
                nombre = "Javier Santaolalla",
                correo = "javi@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.saenz,
                nombre = "Eduardo Saenz",
                correo = "saenz@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.evariste_galois,
                nombre = "Galois",
                correo = "galois@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.einstein,
                nombre = "Albert Einstein",
                correo = "einstein@gmail.com",
                telefono = "666666666",
            ),
            Persona(
                imagen = R.drawable.oppenheimer,
                nombre = "Oppenheimer",
                correo = "oppenheimer@gmail.com",
                telefono = "666666666",
            ),
        )

        //adapterRecyclerView = AdapterRecyclerView(listaPersonas): Se crea una instancia del adaptador
        //personalizado AdapterRecyclerView, que se espera que tenga una lista de objetos
        //Persona (listaPersonas) como su conjunto de datos.
        adapterRecyclerView = AdapterRecyclerViewPersona(listaPersonas, this)
        //apply permite realizar múltiples configuraciones en binding.rv sin tener que repetir binding.rv.
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@ActividadPrimerEjercicio1)
            adapter = adapterRecyclerView
        }
    }

    override fun onItemClick(persona: Persona) {
        val intent = Intent(this, ActividadPrimerEjercicio2::class.java)
        intent.putExtra("persona", persona)
        startActivity(intent)
    }

    override fun onLongItemClick(persona: Persona) {
        eliminarPersonaAutomaticamente(persona)
    }

    private fun eliminarPersonaAutomaticamente(persona: Persona) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar contacto")
        builder.setMessage("¿Estás seguro de que deseas eliminar este contacto?")
        builder.setPositiveButton("Sí") { _, _ ->
            // Elimina la persona de la lista
            adapterRecyclerView.eliminarPersona(persona)
            // Notifica al adaptador que se ha eliminado un elemento
            adapterRecyclerView.notifyDataSetChanged()
        }
        builder.setNegativeButton("No") { _, _ ->
            // No hacer nada si el usuario elige no eliminar
        }
        val dialog = builder.create()
        dialog.show()
    }
}