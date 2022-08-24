package com.example.wltrackingmobile

import android.media.Image
import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Dao
import androidx.room.Query
import com.example.wltrackingmobile.adapters.activitymainclientesadapter
import com.example.wltrackingmobile.adapters.activityvisualizachipsadapter
import com.example.wltrackingmobile.adapters.activityvisualizaclientesadapter
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.chips_rastreadores
import com.example.wltrackingmobile.model.rastreadores
import com.example.wltrackingmobile.model.veiculos
import com.google.android.material.textfield.TextInputEditText
import java.nio.file.Files.size

class VisualizaChipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_chip)
        configuraRecyclerView()
        configuraspinners()
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
    fun configuraspinners(){
        val extras = intent.extras
        val value = extras?.getString("key")
        val db = AppDatabase.instancia(this)
        val spinnerelementes = db.funcoesdbdao().findChipsRastreadoresPorImeiChip(value.toString())
        val arraySpinner = listOf("Rastreadores:",spinnerelementes)
        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraySpinner)
        val ActivityVisualizaChipSpinner2 = findViewById<Spinner>(R.id.ActivityVisualizaChipSpinner2)
        ActivityVisualizaChipSpinner2.adapter = arrayAdapter
    }
}