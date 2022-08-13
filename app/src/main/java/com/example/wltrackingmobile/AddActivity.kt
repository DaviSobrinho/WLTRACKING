package com.example.wltrackingmobile

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cliente)
        title = "Adicionar"
        botaoCliente()
        botaoVeiculo()
        botaoRastreador()
        botaoChip()
    }
    fun botaoCliente(){
        val botaocliente = findViewById<Button>(R.id.ActivityAddButtonClientes)
        botaocliente.setOnClickListener(){
            setContentView(R.layout.activity_add_cliente)
        }
    }
    fun botaoVeiculo(){
        val botaoveiculo = findViewById<Button>(R.id.ActivityAddButtonVeiculos)
        botaoveiculo.setOnClickListener(){
            setContentView(R.layout.activity_add_veiculo)
        }
    }
    fun botaoRastreador(){
        val botaorastreadores = findViewById<Button>(R.id.ActivityAddButtonRastreadores)
        botaorastreadores.setOnClickListener(){

        }
    }
    fun botaoChip(){
        val botaochips = findViewById<Button>(R.id.ActivityAddButtonChips)
        botaochips.setOnClickListener(){

        }
    }
}