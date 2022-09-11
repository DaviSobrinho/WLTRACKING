package com.example.wltrackingmobile.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.adapters.activityvisualizaclientesadapter
import com.example.wltrackingmobile.database.AppDatabase
import com.google.android.material.textfield.TextInputEditText

class VisualizaClienteActivity : AppCompatActivity() {

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
        configuraSpinner1()
        configuraSpinner2()
        configuraSpinner3()
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
    private fun configuraSpinner1(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementsList = db.funcoesdbdao().findVeiculosClientesPorCpfCliente(value.toString())
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
        val arraySpinnerFinal : MutableList<String> = ArrayList(listOf("VEÍCULOS:"))
        arraySpinnerFinal.addAll(arraySpinner)
        val arrayAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinnerFinal)
        val activityVisualizaClienteSpinner1 = findViewById<Spinner>(R.id.ActivityVisualizaClienteSpinner1)
        activityVisualizaClienteSpinner1.adapter = arrayAdapter
    }
    private fun configuraSpinner2(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementsList = db.funcoesdbdao().findRastreadoresClientesPorCpfCliente(value.toString())
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
        val activityVisualizaClienteSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaClienteSpinner2)
        activityVisualizaClienteSpinner2.adapter = arrayAdapter
    }
    private fun configuraSpinner3(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerElementsList = db.funcoesdbdao().findChipsClientesPorCpfCliente(value.toString())
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
        val activityVisualizaClienteSpinner3 = findViewById<Spinner>(R.id.ActivityVisualizaClienteSpinner3)
        activityVisualizaClienteSpinner3.adapter = arrayAdapter
    }
}