package com.example.appaprendizaje.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appaprendizaje.R
import com.example.appaprendizaje.model.CategoriaEntity

class CategoriaAdapter(
    private var categorias: List<CategoriaEntity>,
    private val onEdit: (CategoriaEntity) -> Unit,
    private val onDelete: (CategoriaEntity) -> Unit
) : RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNombreCategoria)
        val descripcion: TextView = itemView.findViewById(R.id.tvDescripcionCategoria)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditar)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = categorias.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoria = categorias[position]
        holder.nombre.text = categoria.nombre
        holder.descripcion.text = categoria.descripcion

        holder.btnEditar.setOnClickListener { onEdit(categoria) }
        holder.btnEliminar.setOnClickListener { onDelete(categoria) }
    }

    fun actualizarLista(nuevaLista: List<CategoriaEntity>) {
        categorias = nuevaLista
        notifyDataSetChanged()
    }
}
