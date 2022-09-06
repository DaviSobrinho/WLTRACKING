package com.example.wltrackingmobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.adapters.activityvisualizachipsadapter
import com.example.wltrackingmobile.database.AppDatabase

class VisualizaChipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_chip)
        configuraRecyclerView()
    }
    private fun configuraRecyclerView() {
        val extras = intent.extras
        val value = extras?.getString("key")
        val adapter = activityvisualizachipsadapter(context = applicationContext)
        val db = AppDatabase.instancia(this)
        val funcoesdbdao = db.funcoesdbdao()
        adapter.atualiza(funcoesdbdao.findChipPorimei(imei = value))
        val recyclerView = findViewById<RecyclerView>(R.id.ActivityVisualizaChipRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    fun configuraSpinner1(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerelementes = db.funcoesdbdao().findChipsClientesporImeiChip(value.toString())
        val arraySpinner = listOf("Clientes:",spinnerelementes)
        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
        val ActivityVisualizaChipSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner1)
        ActivityVisualizaChipSpinner1.adapter = arrayAdapter
    }
    fun configuraSpinner2(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerelementes = db.funcoesdbdao().findChipsVeiculosporImeiChip(value.toString())
        val arraySpinner = listOf("Veiculos:",spinnerelementes)
        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
        val ActivityVisualizaChipSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner2)
        ActivityVisualizaChipSpinner2.adapter = arrayAdapter
    }
    fun configuraSpinner3(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerelementes = db.funcoesdbdao().findChipsRastreadoresPorImeiChip(value.toString())
        val arraySpinner = listOf("Rastreadores:",spinnerelementes)
        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
        val ActivityVisualizaChipSpinner3 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner3)
        ActivityVisualizaChipSpinner3.adapter = arrayAdapter
    }
}