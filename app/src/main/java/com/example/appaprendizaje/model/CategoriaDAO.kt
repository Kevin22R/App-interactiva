package com.example.appaprendizaje.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CategoriaDAO {
    @Insert
    suspend fun insertar(Categorias: CategoriaEntity)

    @Query("SELECT * FROM Categorias")
    suspend fun obtenerTodos(): List<CategoriaEntity>

    @Update
    suspend fun actualizar(Categorias: CategoriaEntity)

    @Delete
    suspend fun eliminar(Categorias: CategoriaEntity)

}