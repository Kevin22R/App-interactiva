package com.example.appaprendizaje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.room.Database
import com.example.appaprendizaje.model.DatabaseApplication
import com.example.appaprendizaje.model.DocenteEntity
import kotlinx.coroutines.launch

class AgregarDocenteFrgment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_agregar_docente_frgment, container, false)

        val nombreEditText = view.findViewById<EditText>(R.id.etNombre)
        val codigoEditText = view.findViewById<EditText>(R.id.etCodigo)
        val identificacionEditText = view.findViewById<EditText>(R.id.etIdentificacion)
        val correoEditText = view.findViewById<EditText>(R.id.etCorreo)
        val contrasenaEditText = view.findViewById<EditText>(R.id.etContrasena)
        val agregarButton = view.findViewById<Button>(R.id.btnGuardarDocente)

        agregarButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val codigo = codigoEditText.text.toString().toIntOrNull() ?: 0
            val identificacion = identificacionEditText.text.toString().toIntOrNull() ?: 0
            val correo = correoEditText.text.toString()
            val contrasena = contrasenaEditText.text.toString()

            crearDocente(nombre, codigo, identificacion, correo, contrasena)

            // Limpiar campos
            nombreEditText.text.clear()
            codigoEditText.text.clear()
            identificacionEditText.text.clear()
            correoEditText.text.clear()
            contrasenaEditText.text.clear()
        }

        return view
    }

    private fun crearDocente(nombre: String, codigo: Int, identificacion: Int, correo: String, contrasena: String) {
        lifecycleScope.launch {
        DatabaseApplication.database.DocenteDAO().insertar(DocenteEntity(nombre = nombre, Codigo = codigo, Identificacion = identificacion, correo = correo, Contraseña = contrasena))
        }
    }
}
