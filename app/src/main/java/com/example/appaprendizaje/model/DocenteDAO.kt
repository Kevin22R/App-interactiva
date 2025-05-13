package com.example.appaprendizaje.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface DocenteDAO {
    @Insert
    suspend fun insertar(Docentes: DocenteEntity)

    @Query("SELECT * FROM Docentes")
    suspend fun obtenerTodos(): List<DocenteEntity>

    @Update
    suspend fun actualizar(Docentes: DocenteEntity)

    @Delete
    suspend fun eliminar(Docentes: DocenteEntity)

}