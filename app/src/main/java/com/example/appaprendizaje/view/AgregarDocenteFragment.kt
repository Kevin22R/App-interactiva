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
import com.example.appaprendizaje.R
import com.example.appaprendizaje.model.DocenteEntity
import com.example.appaprendizaje.viewmodel.DocenteViewModel

class AgregarDocenteFragment : Fragment() {

    companion object {
        const val ARG_DOCENTE = "docente"
    }

    private lateinit var docenteViewModel: DocenteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_agregar_docente_frgment, container, false)

        val etNombre = view.findViewById<EditText>(R.id.etNombre)
        val etCodigo = view.findViewById<EditText>(R.id.etCodigo)
        val etIdentificacion = view.findViewById<EditText>(R.id.etIdentificacion)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etContrasena = view.findViewById<EditText>(R.id.etContrasena)
        val btnGuardar = view.findViewById<Button>(R.id.btnGuardarDocente)

        docenteViewModel = ViewModelProvider(requireActivity())[DocenteViewModel::class.java]

        val docente = arguments?.getParcelable<DocenteEntity>(ARG_DOCENTE)

        if (docente != null) {
            // Modo edición
            etNombre.setText(docente.nombre)
            etCodigo.setText(docente.Codigo.toString())
            etIdentificacion.setText(docente.Identificacion.toString())
            etCorreo.setText(docente.correo)
            etContrasena.setText(docente.contrasena)
            btnGuardar.text = "Actualizar"

            btnGuardar.setOnClickListener {
                val nuevoNombre = etNombre.text.toString().trim()
                val nuevoCodigo = etCodigo.text.toString().toIntOrNull()
                val nuevaIdentificacion = etIdentificacion.text.toString().toIntOrNull()
                val nuevoCorreo = etCorreo.text.toString().trim()
                val nuevaContrasena = etContrasena.text.toString().trim()

                if (nuevoNombre.isNotBlank() && nuevoCodigo != null && nuevaIdentificacion != null && nuevoCorreo.isNotBlank() && nuevaContrasena.isNotBlank()) {
                    val docenteActualizado = docente.copy(
                        nombre = nuevoNombre,
                        Codigo = nuevoCodigo,
                        Identificacion = nuevaIdentificacion,
                        correo = nuevoCorreo,
                        contrasena = nuevaContrasena
                    )
                    docenteViewModel.actualizarDocente(docenteActualizado)
                    Toast.makeText(requireContext(), "Docente actualizado", Toast.LENGTH_SHORT).show()
                    requireActivity().supportFragmentManager.popBackStack()
                } else {
                    Toast.makeText(requireContext(), "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            btnGuardar.setOnClickListener {
                val nombre = etNombre.text.toString().trim()
                val codigo = etCodigo.text.toString().toIntOrNull()
                val identificacion = etIdentificacion.text.toString().toIntOrNull()
                val correo = etCorreo.text.toString().trim()
                val contrasena = etContrasena.text.toString().trim()

                if (nombre.isNotBlank() && codigo != null && identificacion != null && correo.isNotBlank() && contrasena.isNotBlank()) {
                    val nuevoDocente = DocenteEntity(
                        nombre = nombre,
                        Codigo = codigo,
                        Identificacion = identificacion,
                        correo = correo,
                        contrasena = contrasena
                    )
                    docenteViewModel.insertarDocente(nuevoDocente)
                    Toast.makeText(requireContext(), "Docente agregado", Toast.LENGTH_SHORT).show()
                    etNombre.text.clear()
                    etCodigo.text.clear()
                    etIdentificacion.text.clear()
                    etCorreo.text.clear()
                    etContrasena.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }
}
