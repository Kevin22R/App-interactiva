package com.example.appaprendizaje.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Docentes")
data class DocenteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val Codigo:Int,
    val Identificacion: Int,
    val correo:String,
    val Contraseña:String

)
