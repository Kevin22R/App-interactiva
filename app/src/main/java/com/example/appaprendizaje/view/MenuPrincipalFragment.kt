package com.example.appaprendizaje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.appaprendizaje.R

class MenuPrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_menu_principal, container, false)

        val btnAgregarDocente = root.findViewById<Button>(R.id.btnAgregarDocente)
        val btnAgregarCategoria = root.findViewById<Button>(R.id.btnAgregarCategoria)
        val btnMostrarDocentes = root.findViewById<Button>(R.id.btnMostrarDocentes)
        val btnMostrarCategorias = root.findViewById<Button>(R.id.btnMostrarCategorias)

        btnAgregarDocente.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_agregarDocenteFrgment)
        }

        btnAgregarCategoria.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_agregarCategoriaFragment)
        }

        btnMostrarDocentes.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_verDocenteFragment)
        }

        btnMostrarCategorias.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_verCategoriaFragment)
        }

        return root
    }
}
