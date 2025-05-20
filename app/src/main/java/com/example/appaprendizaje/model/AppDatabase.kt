package com.example.appaprendizaje.model


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DocenteEntity::class, CategoriaEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun docenteDAO(): DocenteDAO
    abstract fun categoriaDAO(): CategoriaDAO
}