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
        configuraSpinner1()
        configuraSpinner2()
        configuraSpinner3()
    }
    private fun configuraRecyclerView() {
        val extras = intent.extras
        val value = extras?.getString("key")
        val adapter = activityvisualizachipsadapter(context = this)
        val db = AppDatabase.instancia(this)
        val funcoesdbdao = db.funcoesdbdao()
        adapter.atualiza(funcoesdbdao.findChipPorimei(imei = value))
        val recyclerView = findViewById<RecyclerView>(R.id.ActivityVisualizaChipRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    private fun configuraSpinner1(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementslist = db.funcoesdbdao().findChipsClientesporImeiChip(value.toString())
        var contador = 0
        val arraySpinner : MutableList<String> = ArrayList(listOf())
        while(contador <= spinnerElementslist.lastIndex){
            val itemholder = spinnerElementslist.elementAt(contador).toString()
            arraySpinner.add(itemholder)
            contador++
        }
        arraySpinner.sortWith(
            compareBy(String.CASE_INSENSITIVE_ORDER) { it }
        )
        val arraySpinnerFinal : MutableList<String> = ArrayList(listOf("CLIENTES:"))
        arraySpinnerFinal.addAll(arraySpinner)
        val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinnerFinal)
        val activityVisualizaChipSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner1)
        activityVisualizaChipSpinner1.adapter = arrayAdapter
    }
    private fun configuraSpinner2(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElements = db.funcoesdbdao().findChipsVeiculosporImeiChip(value.toString())
        val arraySpinner = listOf("VEÍCULOS:",spinnerElements)
        val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
        val activityVisualizaChipSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner2)
        activityVisualizaChipSpinner2.adapter = arrayAdapter
    }
    private fun configuraSpinner3(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElements = db.funcoesdbdao().findChipsRastreadoresPorImeiChip(value.toString())
        val arraySpinner = listOf("RASTREADORES:",spinnerElements)
        val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
        val activityVisualizaChipSpinner3 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner3)
        activityVisualizaChipSpinner3.adapter = arrayAdapter
    }
}