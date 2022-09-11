package com.example.wltrackingmobile.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.veiculos
import com.google.android.material.textfield.TextInputEditText

class AddActivityVeiculo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_veiculo)
        title = "Adicionar"
        startAddActivities()
        criaCliente()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    private fun startAddActivities(){
        val activityclientes = findViewById<Button>(R.id.ActivityAddVeiculoButtonClientes)
        activityclientes.setOnClickListener{
            val intent = Intent(this, AddActivityCliente::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activitychips = findViewById<Button>(R.id.ActivityAddVeiculoButtonChips)
        activitychips.setOnClickListener{
            val intent = Intent(this, AddActivityChip::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityveiculos = findViewById<Button>(R.id.ActivityAddVeiculoButtonVeiculos)
        activityveiculos.setOnClickListener{
            val intent = Intent(this, AddActivityVeiculo::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityrastreadores = findViewById<Button>(R.id.ActivityAddVeiculoButtonRastreadores)
        activityrastreadores.setOnClickListener{
            val intent = Intent(this, AddActivityRastreador::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
    fun criaCliente() {
        val db = AppDatabase.instancia(this)
        val botaoadicionar = findViewById<Button>(R.id.ActivityAddVeiculoButtonConfirmar)
        botaoadicionar.setOnClickListener {

            val addmodelo = findViewById<TextInputEditText>(R.id.ActivityAddVeiculoTextInput1)
            val modelo: String = addmodelo.text.toString()
            val addplaca = findViewById<TextInputEditText>(R.id.ActivityAddVeiculoTextInput2)
            val placa: String = addplaca.text.toString()
            val addano = findViewById<TextInputEditText>(R.id.ActivityAddVeiculoTextInput3)
            val ano: String = addano.text.toString()
            val addnotas = findViewById<TextInputEditText>(R.id.ActivityAddVeiculoTextInput4)
            val notas: String = addnotas.text.toString()
            val veiculosDao = db.funcoesdbdao()
            veiculosDao.salvaveiculos(
                veiculos(
                    modelo = modelo,
                    placa = placa,
                    ano = ano,
                    notas = notas,
                )
            )
            val text = "O Veículo foi adicionado!"
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