package com.example.wltrackingmobile.adapters

import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.clientes
import com.example.wltrackingmobile.model.rastreadores
import com.example.wltrackingmobile.model.veiculos
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class activityvisualizarastreadoresadapter (private val context: Context, rastreadores: List<rastreadores> = emptyList(), ) :
    RecyclerView.Adapter<activityvisualizarastreadoresadapter.ViewHolder>() {

    private val rastreadores = rastreadores.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(rastreadores: rastreadores) {
            val modelo = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaRastreadorTextInput1)
            modelo.text = Editable.Factory.getInstance().newEditable(rastreadores.modelo)
            val imei = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaRastreadorTextInput2)
            imei.text = Editable.Factory.getInstance().newEditable(rastreadores.imei)
            val local = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaRastreadorTextInput3)
            local.text = Editable.Factory.getInstance().newEditable(rastreadores.local)
            val estado = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaRastreadorTextInput4)
            estado.text = Editable.Factory.getInstance().newEditable(rastreadores.estado)
            val notas = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaRastreadorTextInput5)
            notas.text = Editable.Factory.getInstance().newEditable(rastreadores.notas)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_visualiza_rastreador_recyclerviewcontent, parent, false)
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