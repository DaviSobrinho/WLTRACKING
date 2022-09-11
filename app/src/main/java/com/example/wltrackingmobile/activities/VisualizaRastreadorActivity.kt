package com.example.wltrackingmobile.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.adapters.activityvisualizarastreadoresadapter
import com.example.wltrackingmobile.database.AppDatabase

class VisualizaRastreadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_rastreador)
        configuraRecyclerView()
        configuraSpinner1()
        configuraSpinner2()
        configuraSpinner3()
    }
    private fun configuraRecyclerView() {
        val extras = intent.extras
        val value = extras?.getString("key")
        val adapter = activityvisualizarastreadoresadapter(context = this)
        val db = AppDatabase.instancia(this)
        val funcoesdbdao = db.funcoesdbdao()
        adapter.atualiza(funcoesdbdao.findRastreadoresPorimei(imei = value))
        val recyclerView = findViewById<RecyclerView>(R.id.ActivityVisualizaRastreadorRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    private fun configuraSpinner1(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElements = db.funcoesdbdao().findRastreadoresClientesporImeiRastreador(value.toString())
        if (spinnerElements != null){
            val arraySpinner = listOf("CLIENTE:",spinnerElements)
            val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val activityVisualizaRastreadorSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaRastreadorSpinner1)
            activityVisualizaRastreadorSpinner1.adapter = arrayAdapter
        }else{
            val arraySpinner = listOf("CLIENTE:")
            val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val activityVisualizaRastreadorSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaRastreadorSpinner1)
            activityVisualizaRastreadorSpinner1.adapter = arrayAdapter
        }

    }
    private fun configuraSpinner2(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElements = db.funcoesdbdao().findRastreadoresVeiculosPorImeiRastreador(value.toString())
        if (spinnerElements != null){
            val arraySpinner = listOf("VEÍCULO:",spinnerElements)
            val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val activityVisualizaRastreadorSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaRastreadorSpinner2)
            activityVisualizaRastreadorSpinner2.adapter = arrayAdapter
        }else{
            val arraySpinner = listOf("VEÍCULO:")
            val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val activityVisualizaRastreadorSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaRastreadorSpinner2)
            activityVisualizaRastreadorSpinner2.adapter = arrayAdapter
        }
    }
    private fun configuraSpinner3(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementsList = db.funcoesdbdao().findChipsRastreadoresPorImeiRastreador(value.toString())
        var contador = 0
        val arraySpinner : MutableList<String> = ArrayList(listOf())
        while(contador <= spinnerElementsList.lastIndex){
            val itemHolder = spinnerElementsList.elementAt(contador).toString()
            arraySpinner.add(itemHolder)
            contador++
        }
        arraySpinner.sortWith(
            compareBy(String.CASE_INSENSITIVE_ORDER) { it }
        )
        val arraySpinnerFinal : MutableList<String> = ArrayList(listOf("CHIPS:"))
        arraySpinnerFinal.addAll(arraySpinner)
        val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinnerFinal)
        val activityVisualizaRastreadorSpinner3 = findViewById<Spinner>(R.id.ActivityVisualizaRastreadorSpinner3)
        activityVisualizaRastreadorSpinner3.adapter = arrayAdapter
    }
}