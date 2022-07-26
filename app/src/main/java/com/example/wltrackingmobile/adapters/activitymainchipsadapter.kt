package com.example.wltrackingmobile.adapters

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.model.chips

class activitymainchipsadapter (private val context: Context, chips: List<chips> = emptyList(),

    ) : RecyclerView.Adapter<activitymainchipsadapter.ViewHolder>() {

    private val chips = chips.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(chips: chips) {
            val imei = itemView.findViewById<TextView>(R.id.Fragment_chips_Imei)
            imei.text = (chips.imei)
            val estado = itemView.findViewById<TextView>(R.id.Fragment_chips_Estado)
            estado.text = (chips.estado)
            val modelo = itemView.findViewById<TextView>(R.id.Fragment_chips_Modelo)
            modelo.text = (chips.modelo)
            val telefone = itemView.findViewById<TextView>(R.id.Fragment_chips_Telefone)
            telefone.text = (chips.telefone)
            val custo = itemView.findViewById<TextView>(R.id.Fragment_chips_Custo)
            custo.text = (chips.custo)
            val dia = itemView.findViewById<TextView>(R.id.Fragment_chips_Dia)
            dia.text = (chips.dia)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_chips2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chips = chips[position]
        holder.vincula(chips)
    }
    override fun getItemCount(): Int = chips.size
    fun atualiza(chips: List<chips>) {
        this.chips.clear()
        this.chips.addAll(chips)
        notifyDataSetChanged()
    }
}