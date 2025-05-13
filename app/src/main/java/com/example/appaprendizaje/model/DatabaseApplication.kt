package com.example.appaprendizaje.model

import android.app.Application
import androidx.room.Room

class DatabaseApplication: Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "mi_base_de_datos"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}