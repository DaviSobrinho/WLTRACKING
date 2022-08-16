package com.example.wltrackingmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.model.veiculos

class activitymainveiculosadapter (private val context: Context, veiculos: List<veiculos> = emptyList(), ) :
    RecyclerView.Adapter<activitymainveiculosadapter.ViewHolder>() {

    private val veiculos = veiculos.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(veiculos: veiculos) {
            val placa = itemView.findViewById<TextView>(R.id.Fragment_veiculos_placa)
            placa.text = (veiculos.placa)
            val modelo = itemView.findViewById<TextView>(R.id.Fragment_rastreadores_Modelo)
            modelo.text = (veiculos.modelo)
            val ano = itemView.findViewById<TextView>(R.id.Fragment_rastreadores_estado)
            ano.text = (veiculos.ano)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_veiculos_recyclerviewcontent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val veiculos = veiculos[position]
        holder.vincula(veiculos)
    }
    override fun getItemCount(): Int = veiculos.size
    fun atualiza(veiculos: List<veiculos>) {
        this.veiculos.clear()
        this.veiculos.addAll(veiculos)
        notifyDataSetChanged()
    }
}