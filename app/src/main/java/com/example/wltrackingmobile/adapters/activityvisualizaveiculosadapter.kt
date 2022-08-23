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
import com.example.wltrackingmobile.model.veiculos
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class activityvisualizaveiculosadapter (private val context: Context, veiculos: List<veiculos> = emptyList(), ) :
    RecyclerView.Adapter<activityvisualizaveiculosadapter.ViewHolder>() {

    private val veiculos = veiculos.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(veiculos: veiculos) {
            val placa = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaVeiculoTextInput1)
            placa.text = Editable.Factory.getInstance().newEditable(veiculos.placa)
            val modelo = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaVeiculoTextInput2)
            modelo.text = Editable.Factory.getInstance().newEditable(veiculos.modelo)
            val ano = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaVeiculoTextInput3)
            ano.text = Editable.Factory.getInstance().newEditable(veiculos.ano)
            val notas = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaVeiculoTextInput4)
            notas.text = Editable.Factory.getInstance().newEditable(veiculos.notas)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_visualiza_veiculo_recyclerviewcontent, parent, false)
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