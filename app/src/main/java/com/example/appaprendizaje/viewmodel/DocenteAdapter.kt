package com.example.appaprendizaje.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appaprendizaje.R
import com.example.appaprendizaje.model.DocenteEntity

class DocenteAdapter(
    private var docentes: List<DocenteEntity>,
    private val onEdit: (DocenteEntity) -> Unit,
    private val onDelete: (DocenteEntity) -> Unit
) : RecyclerView.Adapter<DocenteAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNombreDocente)
        val correo: TextView = itemView.findViewById(R.id.tvEmailDocente)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditarDocente)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminarDocente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_docente, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = docentes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val docente = docentes[position]
        holder.nombre.text = docente.nombre
        holder.correo.text = docente.correo

        holder.btnEditar.setOnClickListener { onEdit(docente) }
        holder.btnEliminar.setOnClickListener { onDelete(docente) }
    }

    fun actualizarLista(nuevaLista: List<DocenteEntity>) {
        docentes = nuevaLista
        notifyDataSetChanged()
    }
}
