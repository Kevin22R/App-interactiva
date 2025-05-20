package com.example.appaprendizaje.viewmodel

import com.example.appaprendizaje.model.CategoriaDAO
import com.example.appaprendizaje.model.CategoriaEntity

class CategoriaRepository(private val dao: CategoriaDAO) {

    suspend fun insertar(categoria: CategoriaEntity) {
        dao.insertar(categoria)
    }

    suspend fun obtenerTodos(): List<CategoriaEntity> {
        return dao.obtenerTodos()
    }

    suspend fun actualizar(categoria: CategoriaEntity) {
        dao.actualizar(categoria)
    }

    suspend fun eliminar(categoria: CategoriaEntity) {
        dao.eliminar(categoria)
    }
}
