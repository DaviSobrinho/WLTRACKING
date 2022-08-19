package com.example.wltrackingmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.adapters.activitymainclientesadapter
import com.example.wltrackingmobile.adapters.activityvisualizaclientesadapter
import com.example.wltrackingmobile.database.AppDatabase
import com.google.android.material.textfield.TextInputEditText

class VisualizaClienteActivity : AppCompatActivity() {

    private val adapter = activityvisualizaclientesadapter(context = this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_cliente)
        configuraRecyclerView()
        val textInput1 = findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput1)
        val textInput2 = findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput2)
        val textInput3 = findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput3)
        val textInput4 = findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput4)
        val textInput5 = findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput5)
        val textInput6 = findViewById<TextInputEditText>(R.id.ActivityVisualizaClienteTextInput6)
    }
    private fun configuraRecyclerView() {
        val extras = intent.extras
        val value = extras?.getString("key")
        val adapter = activityvisualizaclientesadapter(context = this)
        val db = AppDatabase.instancia(this)
        val funcoesdbdao = db.funcoesdbdao()
        adapter.atualiza(funcoesdbdao.findClientePorCPF(cpf = value))
        val recyclerView = findViewById<RecyclerView>(R.id.ActivityVisualizaClienteRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}