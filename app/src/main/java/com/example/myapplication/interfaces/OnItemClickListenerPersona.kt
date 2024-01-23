package com.example.myapplication.interfaces

import com.example.myapplication.modelos.Persona

interface OnItemClickListenerPersona {
    fun onItemClick(persona: Persona)
    fun onLongItemClick(persona: Persona)
}