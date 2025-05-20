package com.example.appaprendizaje.viewmodel

import com.example.appaprendizaje.model.DocenteDAO
import com.example.appaprendizaje.model.DocenteEntity

class DocenteRepository(private val dao: DocenteDAO) {

    suspend fun insertar(docente: DocenteEntity) {
        dao.insertar(docente)
    }

    suspend fun obtenerTodos(): List<DocenteEntity> {
        return dao.obtenerTodos()
    }

    suspend fun actualizar(docente: DocenteEntity) {
        dao.actualizar(docente)
    }

    suspend fun eliminar(docente: DocenteEntity) {
        dao.eliminar(docente)
    }
}
