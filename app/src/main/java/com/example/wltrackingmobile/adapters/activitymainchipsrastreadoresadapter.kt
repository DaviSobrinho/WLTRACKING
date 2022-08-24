package com.example.wltrackingmobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.model.chips_rastreadores

class activitymainchipsrastreadoresadapter (private val context: Context,
                                            chips_rastreadores: List<chips_rastreadores> = emptyList(),

                                            ) : RecyclerView.Adapter<activitymainchipsrastreadoresadapter.ViewHolder>() {

    private val chips_rastreadores = chips_rastreadores.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(chips_rastreadores: chips_rastreadores) {
            val imeichip = itemView.findViewById<TextView>(R.id.Fragment_veiculos_ano)
            imeichip.text = (chips_rastreadores.imeichip)
            val imeirastreador = itemView.findViewById<TextView>(R.id.Fragment_veiculos_modelo)
            imeirastreador.text = (chips_rastreadores.imeirastreador)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_veiculos_recyclerviewcontent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chips_rastreadores = chips_rastreadores[position]
        holder.vincula(chips_rastreadores)
    }
    override fun getItemCount(): Int = chips_rastreadores.size
    fun atualiza(chips_rastreadores: List<chips_rastreadores>) {
        this.chips_rastreadores.clear()
        this.chips_rastreadores.addAll(chips_rastreadores)
        notifyDataSetChanged()
    }
}