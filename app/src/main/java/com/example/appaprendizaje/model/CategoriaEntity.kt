package com.example.appaprendizaje.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Categorias")
data class CategoriaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre_Categoria: String,
    val Descrpcion:String

)

