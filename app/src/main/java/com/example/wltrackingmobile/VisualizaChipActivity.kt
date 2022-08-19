package com.example.wltrackingmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wltrackingmobile.adapters.activitymainclientesadapter
import com.example.wltrackingmobile.adapters.activityvisualizachipsadapter
import com.example.wltrackingmobile.adapters.activityvisualizaclientesadapter
import com.example.wltrackingmobile.database.AppDatabase
import com.google.android.material.textfield.TextInputEditText

class VisualizaChipActivity : AppCompatActivity() {

    private val adapter = activityvisualizachipsadapter(context = this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualiza_chip)
        configuraRecyclerView()
        val textInput1 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput1)
        val textInput2 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput2)
        val textInput3 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput3)
        val textInput4 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput4)
        val textInput5 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput5)
        val textInput6 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput6)
        val textInput7 = findViewById<TextInputEditText>(R.id.ActivityVisualizaChipTextInput7)
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