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
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class activityvisualizachipsadapter (private val context: Context, chips: List<chips> = emptyList(), ) :
    RecyclerView.Adapter<activityvisualizachipsadapter.ViewHolder>() {

    private val chips = chips.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(chips: chips) {
            val imei = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput1)
            imei.text = Editable.Factory.getInstance().newEditable(chips.imei)
            val modelo = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput2)
            modelo.text = Editable.Factory.getInstance().newEditable(chips.modelo)
            val telefone = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput3)
            telefone.text = Editable.Factory.getInstance().newEditable(chips.telefone)
            val dia = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput4)
            dia.text = Editable.Factory.getInstance().newEditable(chips.dia)
            val custo = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput5)
            custo.text = Editable.Factory.getInstance().newEditable(chips.custo)
            val estado = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput6)
            estado.text = Editable.Factory.getInstance().newEditable(chips.estado)
            val notas = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput7)
            notas.text = Editable.Factory.getInstance().newEditable(chips.notas)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_visualiza_chip_recyclerviewcontent, parent, false)
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