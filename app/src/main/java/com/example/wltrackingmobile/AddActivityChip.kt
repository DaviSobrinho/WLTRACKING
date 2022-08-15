package com.example.wltrackingmobile

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.chips
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AddActivityChip : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_chip)
        title = "Adicionar"
        startAddActivities()
        criaChip()
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
    private fun startAddActivities(){
        val activityclientes = findViewById<Button>(R.id.ActivityAddChipButtonClientes)
        activityclientes.setOnClickListener{
            val intent = Intent(this, AddActivityCliente::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activitychips = findViewById<Button>(R.id.ActivityAddChipButtonChips)
        activitychips.setOnClickListener{
            val intent = Intent(this, AddActivityChip::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityveiculos = findViewById<Button>(R.id.ActivityAddChipButtonVeiculos)
        activityveiculos.setOnClickListener{
            val intent = Intent(this, AddActivityVeiculo::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityrastreadores = findViewById<Button>(R.id.ActivityAddChipButtonRastreadores)
        activityrastreadores.setOnClickListener{
            val intent = Intent(this, AddActivityRastreador::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
    private fun criaChip() {
        val db = AppDatabase.instancia(this)
        val botaoadicionar = findViewById<Button>(R.id.ActivityAddChipButtonConfirmar)
        botaoadicionar.setOnClickListener {
            val addimei = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput1)
            val imei: String = addimei.text.toString()
            val chipsDao = db.funcoesdbdao()
            chipsDao.salva(
                chips(
                    imei = imei,
                    estado = "estado",
                    telefone = "telefone",
                    dia = "data",
                    custo = "valor",
                    modelo = "contrato",
                )
            )
            val text = "O chip foi adicionado!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }
    private fun startMainActivity(){
        val intent = Intent(applicationContext, MainActivity::class.java)
        val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        startActivity(intent, bundle)
    }
}