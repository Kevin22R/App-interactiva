package com.example.appaprendizaje.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appaprendizaje.viewmodel.CategoriaAdapter
import com.example.appaprendizaje.viewmodel.CategoriaViewModel
import com.example.appaprendizaje.R

class VerCategoriaFragment : Fragment() {

    private lateinit var viewModel: CategoriaViewModel
    private lateinit var adapter: CategoriaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ver_categoria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[CategoriaViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCategorias)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = CategoriaAdapter(
            emptyList(),
            onEdit = { categoria ->
                val action = VerCategoriaFragmentDirections
                    .actionVerCategoriaFragmentToAgregarCategoriaFragment(categoria)
                findNavController().navigate(action)
            },
            onDelete = { categoria ->
                viewModel.eliminarCategoria(categoria)
            }
        )

        recyclerView.adapter = adapter

        viewModel.categorias.observe(viewLifecycleOwner) { categorias ->
            adapter.actualizarLista(categorias)
        }
    }
}
