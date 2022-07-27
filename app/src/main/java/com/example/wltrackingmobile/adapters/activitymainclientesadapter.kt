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

class activitymainclientesadapter (private val context: Context, clientes: List<clientes> = emptyList(), ) :
    RecyclerView.Adapter<activitymainclientesadapter.ViewHolder>() {

    private val clientes = clientes.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(clientes: clientes) {
            val nome = itemView.findViewById<TextView>(R.id.Fragment_clientes_nome)
            nome.text = (clientes.nome)
            val cpf = itemView.findViewById<TextView>(R.id.Fragment_clientes_cpf)
            cpf.text = (clientes.cpf)
            val telefone = itemView.findViewById<TextView>(R.id.Fragment_clientes_telefone)
            telefone.text = (clientes.telefone)
            val contrato = itemView.findViewById<TextView>(R.id.Fragment_clientes_contrato)
            contrato.text = (clientes.contrato)
            val notas = itemView.findViewById<TextView>(R.id.Fragment_clientes_notas)
            notas.text = (clientes.notas)
            val valor = itemView.findViewById<TextView>(R.id.Fragment_clientes_valor)
            valor.text = (clientes.valor)
            val data = itemView.findViewById<TextView>(R.id.Fragment_clientes_data)
            data.text = (clientes.data)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_clientes_recyclerviewcontent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val clientes = clientes[position]
        holder.vincula(clientes)
    }
    override fun getItemCount(): Int = clientes.size
    fun atualiza(chips: List<chips>) {
        this.clientes.clear()
        this.clientes.addAll(clientes)
        notifyDataSetChanged()
    }
}