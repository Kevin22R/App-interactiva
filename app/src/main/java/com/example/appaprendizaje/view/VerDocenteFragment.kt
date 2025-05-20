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
import com.example.appaprendizaje.R
import com.example.appaprendizaje.viewmodel.DocenteAdapter
import com.example.appaprendizaje.viewmodel.DocenteViewModel

class VerDocenteFragment : Fragment() {

    private lateinit var viewModel: DocenteViewModel
    private lateinit var adapter: DocenteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ver_docente, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[DocenteViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewDocente)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = DocenteAdapter(
            emptyList(),
            onEdit = { docente ->
                val action = VerDocenteFragmentDirections
                    .actionVerDocenteFragmentToAgregarDocenteFragment(docente)
                findNavController().navigate(action)
            },
            onDelete = { docente ->
                viewModel.eliminarDocente(docente)
            }
        )

        recyclerView.adapter = adapter

        viewModel.docentes.observe(viewLifecycleOwner) { docentes ->
            adapter.actualizarLista(docentes)
        }
    }
}
