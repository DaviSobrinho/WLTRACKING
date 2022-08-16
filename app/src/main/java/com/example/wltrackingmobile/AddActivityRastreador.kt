package com.example.wltrackingmobile

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.rastreadores
import com.google.android.material.textfield.TextInputEditText

class AddActivityRastreador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_rastreador)
        title = "Adicionar"
        startAddActivities()
        criaRastreador()
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
    fun criaRastreador() {
        val db = AppDatabase.instancia(this)
        val checkativado = findViewById<CompoundButton>(R.id.ActivityAddRastreadorCheckBox1)
        val checkdesativado = findViewById<CheckBox>(R.id.ActivityAddRastreadorCheckBox2)
        val checkmanutencao = findViewById<CheckBox>(R.id.ActivityAddRastreadorCheckBox3)
        var estado : String = ""
        checkativado.setOnCheckedChangeListener{ buttonView, isChecked ->
            if( isChecked){
                checkdesativado.isChecked = false
                checkmanutencao.isChecked = false
                estado = "Ativado"
                title = estado
            }else{
                estado =""
            }
        }
        checkdesativado.setOnCheckedChangeListener{ buttonView, isChecked ->
            if( isChecked){
                checkativado.isChecked = false
                checkmanutencao.isChecked = false
                estado = "Desativado"
                title = estado
            }else{
                estado =""
            }
        }
        checkmanutencao.setOnCheckedChangeListener{ buttonView, isChecked ->
            if( isChecked){
                checkdesativado.isChecked = false
                checkativado.isChecked = false
                estado = "Manutenção"
                title = estado
            }else{
                estado =""
            }
        }
        val botaoadicionar = findViewById<Button>(R.id.ActivityAddRastreadorButtonConfirmar)

        botaoadicionar.setOnClickListener {
            val addimei = findViewById<TextInputEditText>(R.id.ActivityAddRastreadorTextInput1)
            val imei: String = addimei.text.toString()
            val addmodelo = findViewById<TextInputEditText>(R.id.ActivityAddRastreadorTextInput2)
            val modelo: String = addmodelo.text.toString()
            val rastreadoresDao = db.funcoesdbdao()
            rastreadoresDao.salvarastreadores(
                rastreadores(
                    imei = imei,
                    estado = estado,
                    modelo = modelo,
                )
            )
            val text = "O rastreador foi adicionado!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }
    private fun startAddActivities(){
        val activityclientes = findViewById<Button>(R.id.ActivityAddRastreadorButtonClientes)
        activityclientes.setOnClickListener{
            val intent = Intent(this, AddActivityCliente::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activitychips = findViewById<Button>(R.id.ActivityAddRastreadorButtonChips)
        activitychips.setOnClickListener{
            val intent = Intent(this, AddActivityChip::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityveiculos = findViewById<Button>(R.id.ActivityAddRastreadorButtonVeiculos)
        activityveiculos.setOnClickListener{
            val intent = Intent(this, AddActivityVeiculo::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
        val activityrastreadores = findViewById<Button>(R.id.ActivityAddRastreadorButtonRastreadores)
        activityrastreadores.setOnClickListener{
            val intent = Intent(this, AddActivityRastreador::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
    private fun startMainActivity(){
        val intent = Intent(applicationContext, MainActivity::class.java)
        val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        startActivity(intent, bundle)
    }
}