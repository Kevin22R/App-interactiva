package com.example.appaprendizaje.model

import android.app.Application
import androidx.room.Room

class DatabaseApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_aprendizaje_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}