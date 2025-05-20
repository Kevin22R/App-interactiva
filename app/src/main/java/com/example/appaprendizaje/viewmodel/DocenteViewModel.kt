package com.example.appaprendizaje.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appaprendizaje.model.DatabaseApplication
import com.example.appaprendizaje.model.DocenteEntity
import kotlinx.coroutines.launch

class DocenteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DocenteRepository
    val docentes = MutableLiveData<List<DocenteEntity>>()

    init {
        val dao = DatabaseApplication.database.docenteDAO()
        repository = DocenteRepository(dao)
        obtenerDocentes()
    }

    fun obtenerDocentes() {
        viewModelScope.launch {
            docentes.value = repository.obtenerTodos()
        }
    }

    fun insertarDocente(docente: DocenteEntity) {
        viewModelScope.launch {
            repository.insertar(docente)
            obtenerDocentes()
        }
    }

    fun actualizarDocente(docente: DocenteEntity) {
        viewModelScope.launch {
            repository.actualizar(docente)
            obtenerDocentes()
        }
    }

    fun eliminarDocente(docente: DocenteEntity) {
        viewModelScope.launch {
            repository.eliminar(docente)
            obtenerDocentes()
        }
    }
}
