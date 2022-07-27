package com.example.wltrackingmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.clientes
import com.example.wltrackingmobile.model.rastreadores

class activitymainrastreadoresadapter (private val context: Context, rastreadores: List<rastreadores> = emptyList(), ) :
    RecyclerView.Adapter<activitymainrastreadoresadapter.ViewHolder>() {

    private val rastreadores = rastreadores.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(rastreadores: rastreadores) {
            val imei = itemView.findViewById<TextView>(R.id.Fragment_rastreadores_imei)
            imei.text = (rastreadores.imei)
            val modelo = itemView.findViewById<TextView>(R.id.Fragment_rastreadores_Modelo)
            modelo.text = (rastreadores.modelo)
            val estado = itemView.findViewById<TextView>(R.id.Fragment_rastreadores_estado)
            estado.text = (rastreadores.estado)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_rastreadores_recyclerviewcontent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rastreadores = rastreadores[position]
        holder.vincula(rastreadores)
    }
    override fun getItemCount(): Int = rastreadores.size
    fun atualiza(rastreadores: List<rastreadores>) {
        this.rastreadores.clear()
        this.rastreadores.addAll(rastreadores)
        notifyDataSetChanged()
    }
}