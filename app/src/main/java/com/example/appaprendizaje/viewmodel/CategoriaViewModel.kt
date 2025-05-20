package com.example.appaprendizaje.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appaprendizaje.model.CategoriaEntity
import com.example.appaprendizaje.model.DatabaseApplication
import kotlinx.coroutines.launch

class CategoriaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CategoriaRepository
    val categorias = MutableLiveData<List<CategoriaEntity>>()

    init {
        val dao = DatabaseApplication.database.categoriaDAO()
        repository = CategoriaRepository(dao)
        obtenerCategorias()
    }

    fun obtenerCategorias() {
        viewModelScope.launch {
            categorias.value = repository.obtenerTodos()
        }
    }

    fun eliminarCategoria(categoria: CategoriaEntity) {
        viewModelScope.launch {
            repository.eliminar(categoria)
            obtenerCategorias()
        }
    }

    fun actualizarCategoria(categoria: CategoriaEntity) {
        viewModelScope.launch {
            repository.actualizar(categoria)
            obtenerCategorias()
        }
    }
    fun insertarCategoria(categoria: CategoriaEntity) {
        viewModelScope.launch {
            repository.insertar(categoria)
            obtenerCategorias()
        }
    }

}

