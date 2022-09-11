package com.example.wltrackingmobile.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.adapters.activityvisualizaveiculosadapter
import com.example.wltrackingmobile.database.AppDatabase

class VisualizaVeiculoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_veiculo)
        configuraRecyclerView()
        configuraSpinner1()
        configuraSpinner2()
        configuraSpinner3()

    }
    private fun configuraRecyclerView() {
        val extras = intent.extras
        val value = extras?.getString("key")
        val adapter = activityvisualizaveiculosadapter(context = this)
        val db = AppDatabase.instancia(this)
        val funcoesdbdao = db.funcoesdbdao()
        adapter.atualiza(funcoesdbdao.findveiculosPorplaca(placa = value))
        val recyclerView = findViewById<RecyclerView>(R.id.ActivityVisualizaVeiculoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    private fun configuraSpinner1(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElements = db.funcoesdbdao().findVeiculosClientesPorPlacaVeiculo(value.toString())
        if (spinnerElements != null){
            val arraySpinner = listOf("CLIENTE:",spinnerElements)
            val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val activityVisualizaVeiculoSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaVeiculoSpinner1)
            activityVisualizaVeiculoSpinner1.adapter = arrayAdapter
        }else{
            val arraySpinner = listOf("CLIENTE:")
            val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val activityVisualizaVeiculoSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaVeiculoSpinner1)
            activityVisualizaVeiculoSpinner1.adapter = arrayAdapter
        }

    }
    private fun configuraSpinner2(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementsList = db.funcoesdbdao().findRastreadoresVeiculosPorPlacaVeiculo(value.toString())
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
        val arraySpinnerFinal : MutableList<String> = ArrayList(listOf("RASTREADORES:"))
        arraySpinnerFinal.addAll(arraySpinner)
        val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinnerFinal)
        val activityVisualizaVeiculoSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaVeiculoSpinner2)
        activityVisualizaVeiculoSpinner2.adapter = arrayAdapter

    }
    private fun configuraSpinner3(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementsList = db.funcoesdbdao().findChipsVeiculosPorPlacaVeiculo(value.toString())
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
        val activityVisualizaVeiculoSpinner3 = findViewById<Spinner>(R.id.ActivityVisualizaVeiculoSpinner3)
        activityVisualizaVeiculoSpinner3.adapter = arrayAdapter
    }
}