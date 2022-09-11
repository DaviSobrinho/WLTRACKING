package com.example.wltrackingmobile.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.chips
import com.google.android.material.textfield.TextInputEditText


class AddActivityChip : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_chip)
        title = "Adicionar"
        startAddActivities()
        criaChip()
        configuracheckbox()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
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
    fun criaChip() {
        val db = AppDatabase.instancia(this)
        val checkativado = findViewById<CompoundButton>(R.id.ActivityAddChipCheckBox1)
        val checkdesativado = findViewById<CheckBox>(R.id.ActivityAddChipCheckBox2)
        val checkmanutencao = findViewById<CheckBox>(R.id.ActivityAddChipCheckBox3)
        var estado = ""
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
        val botaoadicionar = findViewById<Button>(R.id.ActivityAddChipButtonConfirmar)

        botaoadicionar.setOnClickListener {
            val addimei = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput1)
            val imei: String = addimei.text.toString()
            val addmodelo = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput2)
            val modelo: String = addmodelo.text.toString()
            val addtelefone = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput3)
            val telefone: String = addtelefone.text.toString()
            val adddia = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput4)
            val dia: String = adddia.text.toString()
            val addcusto = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput5)
            val custo: String = addcusto.text.toString()
            val addnotas = findViewById<TextInputEditText>(R.id.ActivityAddChipTextInput6)
            val notas: String = addnotas.text.toString()
            val chipsDao = db.funcoesdbdao()
            chipsDao.salva(
                chips(
                    imei = imei,
                    estado = estado,
                    telefone = telefone,
                    dia = dia,
                    custo = custo,
                    modelo = modelo,
                    notas = notas,
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
    fun configuracheckbox(){

    }
}