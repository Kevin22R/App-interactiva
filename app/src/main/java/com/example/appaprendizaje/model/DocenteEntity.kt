package com.example.appaprendizaje.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "docentes")
data class DocenteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val Codigo: Int,
    val Identificacion: Int,
    val correo: String,
    val contrasena: String
):Parcelable
