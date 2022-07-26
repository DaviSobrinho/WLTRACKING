/*package com.example.wltrackingmobile.adapters
import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.model.clientes

class TelaClienteAdapter(

    private val context: Context,
    clientes: List<clientes> = emptyList(),

    ) : RecyclerView.Adapter<TelaClienteAdapter.ViewHolder>() {

    private val clientes = clientes.toMutableList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(cliente: clientes) {
            val nome = itemView.findViewById<TextView>(R.id.Fragment_chips_Modelo)
            nome.text = Editable.Factory.getInstance().newEditable(cliente.nome)
            val cpf = itemView.findViewById<TextView>(R.id.edittextcpf)
            cpf.text = Editable.Factory.getInstance().newEditable(cliente.cpf)
            val valor = itemView.findViewById<TextView>(R.id.edittextvalor)
            valor.text = Editable.Factory.getInstance().newEditable(cliente.valor)
            val data = itemView.findViewById<TextView>(R.id.edittextdata)
            data.text = Editable.Factory.getInstance().newEditable(cliente.data)
            val telefone = itemView.findViewById<TextView>(R.id.edittexttelefone)
            telefone.text = Editable.Factory.getInstance().newEditable(cliente.telefone)
            val contrato = itemView.findViewById<TextView>(R.id.edittextcontrato)
            contrato.text = Editable.Factory.getInstance().newEditable(cliente.contrato)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.editexttelacliente, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cliente = clientes[position]
        holder.vincula(cliente)
    }
    override fun getItemCount(): Int = clientes.size
    fun atualiza(clientes: List<clientes>) {
        this.clientes.clear()
        this.clientes.addAll(clientes)
        notifyDataSetChanged()
    }
}*/