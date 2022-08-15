package com.example.wltrackingmobile

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class AddActivityCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cliente)
        title = "Adicionar"
        startAddActivities()
    }

    private fun startAddActivities(){
        val activityclientes = findViewById<Button>(R.id.ActivityAddClienteButtonClientes)
        activityclientes.setOnClickListener{
            val intent = Intent(this, AddActivityCliente::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activitychips = findViewById<Button>(R.id.ActivityAddClienteButtonChips)
        activitychips.setOnClickListener{
            val intent = Intent(this, AddActivityChip::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityveiculos = findViewById<Button>(R.id.ActivityAddClienteButtonVeiculos)
        activityveiculos.setOnClickListener{
            val intent = Intent(this, AddActivityVeiculo::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityrastreadores = findViewById<Button>(R.id.ActivityAddClienteButtonRastreadores)
        activityrastreadores.setOnClickListener{
            val intent = Intent(this, AddActivityRastreador::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
}