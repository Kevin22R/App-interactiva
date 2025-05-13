package com.example.appaprendizaje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MenuPrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_menu_principal, container, false)
        val btnirAgregarDocente = root.findViewById<Button>(R.id.btnAgregarDocente)
        val btnirAgregarCategoria = root.findViewById<Button>(R.id.btnAgregarCategoria)
        val btnirVerDocente = root.findViewById<Button>(R.id.btnMostrarDocentes)
        val btnirVerCategoria = root.findViewById<Button>(R.id.btnAgregarCategoria)

        btnirAgregarDocente.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_agregarDocenteFrgment)
        }

        btnirAgregarCategoria.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_agregarCategoriaFragment)
        }

        btnirVerDocente.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_verDocenteFragment)
        }

        btnirVerCategoria.setOnClickListener {
            findNavController().navigate(R.id.action_menuPrincipalFragment3_to_verCategoriaFragment)
        }

        return root

    }

}