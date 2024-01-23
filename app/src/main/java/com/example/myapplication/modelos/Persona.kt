package com.example.myapplication.modelos

import android.os.Parcel
import android.os.Parcelable

data class Persona(
    val imagen: Int?,
    val nombre: String = "Desconocido",
    val correo: String = "Desconocido",
    val telefono: String = "Desconocido"
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString() ?: "Desconocido",
        parcel.readString() ?: "Desconocido",
        parcel.readString() ?: "Desconocido"
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(imagen)
        parcel.writeString(nombre)
        parcel.writeString(correo)
        parcel.writeString(telefono)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }
}
