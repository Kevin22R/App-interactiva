package com.example.appaprendizaje.model


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DocenteEntity::class,CategoriaEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase(){

    abstract fun DocenteDAO():DocenteDAO
    abstract fun CategoriaDAO():CategoriaDAO
}