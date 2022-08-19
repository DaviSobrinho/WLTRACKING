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

class activityvisualizaclientesadapter (private val context: Context, clientes: List<clientes> = emptyList(), ) :
    RecyclerView.Adapter<activityvisualizaclientesadapter.ViewHolder>() {

    private val clientes = clientes.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(clientes: clientes) {
            val nome = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput1)
            nome.text = Editable.Factory.getInstance().newEditable(clientes.nome)
            val cpf = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput2)
            cpf.text = Editable.Factory.getInstance().newEditable(clientes.cpf)
            val telefone = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput3)
            telefone.text = Editable.Factory.getInstance().newEditable(clientes.telefone)
            val contrato = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput6)
            contrato.text = Editable.Factory.getInstance().newEditable(clientes.contrato)
            val notas = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput7)
            notas.text = Editable.Factory.getInstance().newEditable(clientes.notas)
            val valor = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput5)
            valor.text = Editable.Factory.getInstance().newEditable(clientes.valor)
            val data = itemView.findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput4)
            data.text = Editable.Factory.getInstance().newEditable(clientes.data)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_visualiza_cliente_recyclerviewcontent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val clientes = clientes[position]
        holder.vincula(clientes)
    }
    override fun getItemCount(): Int = clientes.size
    fun atualiza(clientes: List<clientes>) {
        this.clientes.clear()
        this.clientes.addAll(clientes)
        notifyDataSetChanged()
    }
}