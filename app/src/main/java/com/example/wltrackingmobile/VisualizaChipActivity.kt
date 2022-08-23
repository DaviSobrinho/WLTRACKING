package com.example.wltrackingmobile

import android.media.Image
import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.adapters.activitymainclientesadapter
import com.example.wltrackingmobile.adapters.activityvisualizachipsadapter
import com.example.wltrackingmobile.adapters.activityvisualizaclientesadapter
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.chips_rastreadores
import com.example.wltrackingmobile.model.rastreadores
import com.google.android.material.textfield.TextInputEditText

class VisualizaChipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_chip)
        configuraRecyclerView()
        val button = findViewById<ImageView>(R.id.ActivityVisualizaChipImage)
        button.setOnClickListener(){

            val db = AppDatabase.instancia(this)
            val funcoesdbdao = db.funcoesdbdao()
            val imei = (findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput1).text.toString())
            val spinner3 = funcoesdbdao.findChipsRastreadoresPorImeiChip(imei)
            val spinner4 = spinner3.toMutableList()
            val chipsras : List<chips_rastreadores> = emptyList()
            val chipras = chipsras.toMutableList()
            title = chipras.toString()
            val text = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput2)
            text.text = Editable.Factory.getInstance().newEditable(spinner3.toString())
            val arraySpinner = listOf<String>("Rodrigo Leutz","Tutorial","Kotlin","Spinner")
            val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
            val ActivityVisualizaChipSpinner3 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner3)
            ActivityVisualizaChipSpinner3.adapter = arrayAdapter
        }
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
}