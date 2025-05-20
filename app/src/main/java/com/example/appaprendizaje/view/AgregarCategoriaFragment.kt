package com.example.appaprendizaje.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appaprendizaje.model.CategoriaEntity
import com.example.appaprendizaje.viewmodel.CategoriaViewModel
import com.example.appaprendizaje.R

class AgregarCategoriaFragment : Fragment() {

    companion object {
        const val ARG_CATEGORIA = "categoria"
    }

    private lateinit var categoriaViewModel: CategoriaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_agregar_categoria, container, false)

        val nombreCategoriaEditText = view.findViewById<EditText>(R.id.etNombreCategoria)
        val descripcionEditText = view.findViewById<EditText>(R.id.etDescripcion)
        val guardarButton = view.findViewById<Button>(R.id.btnGuardarCategoria)

        categoriaViewModel = ViewModelProvider(requireActivity())[CategoriaViewModel::class.java]


        val categoria = arguments?.getParcelable<CategoriaEntity>(ARG_CATEGORIA)

        if (categoria != null) {
            // Modo edición
            nombreCategoriaEditText.setText(categoria.nombre)
            descripcionEditText.setText(categoria.descripcion)

            guardarButton.setOnClickListener {
                val nuevoNombre = nombreCategoriaEditText.text.toString()
                val nuevaDescripcion = descripcionEditText.text.toString()

                if (nuevoNombre.isNotBlank() && nuevaDescripcion.isNotBlank()) {
                    val categoriaEditada = categoria.copy(
                        nombre = nuevoNombre,
                        descripcion = nuevaDescripcion
                    )
                    categoriaViewModel.actualizarCategoria(categoriaEditada)
                    Toast.makeText(requireContext(), "Categoría actualizada", Toast.LENGTH_SHORT).show()
                    requireActivity().supportFragmentManager.popBackStack()
                } else {
                    Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            guardarButton.setOnClickListener {
                val nombre = nombreCategoriaEditText.text.toString()
                val descripcion = descripcionEditText.text.toString()

                if (nombre.isNotBlank() && descripcion.isNotBlank()) {
                    val nuevaCategoria = CategoriaEntity(nombre = nombre, descripcion = descripcion)
                    categoriaViewModel.insertarCategoria(nuevaCategoria)
                    Toast.makeText(requireContext(), "Categoría agregada", Toast.LENGTH_SHORT).show()
                    nombreCategoriaEditText.text.clear()
                    descripcionEditText.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}
