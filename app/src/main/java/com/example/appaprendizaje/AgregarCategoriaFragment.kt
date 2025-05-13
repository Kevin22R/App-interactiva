package com.example.appaprendizaje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.appaprendizaje.model.CategoriaEntity
import com.example.appaprendizaje.model.DatabaseApplication
import com.example.appaprendizaje.model.DocenteEntity
import kotlinx.coroutines.launch

class AgregarCategoriaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_agregar_categoria, container, false)

        val nombreCategoriaEditText = view.findViewById<EditText>(R.id.etNombreCategoria)
        val descripcionEditText = view.findViewById<EditText>(R.id.etDescripcion)
        val agregarButton = view.findViewById<Button>(R.id.btnGuardarCategoria)

        agregarButton.setOnClickListener {
            val nombreCategoria = nombreCategoriaEditText.text.toString()
            val descripcion = descripcionEditText.text.toString()

            crearCategoria(nombreCategoria, descripcion)

            // Limpiar campos
            nombreCategoriaEditText.text.clear()
            descripcionEditText.text.clear()
        }

        return view
    }

    private fun crearCategoria(nombre: String, descripcion: String) {
        lifecycleScope.launch {
            DatabaseApplication.database.CategoriaDAO().insertar(CategoriaEntity(nombre_Categoria = nombre, Descrpcion = descripcion))
        }
    }
}
