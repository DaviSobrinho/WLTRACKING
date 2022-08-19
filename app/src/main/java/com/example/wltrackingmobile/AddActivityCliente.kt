package com.example.wltrackingmobile

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.widget.CalendarView.OnDateChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.model.clientes
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*


class AddActivityCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cliente)
        title = "Adicionar"
        startAddActivities()
        criaCliente()
    }
    override fun onBackPressed() {
        super.onBackPressed()
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
    fun criaCliente() {
        val db = AppDatabase.instancia(this)
        val botaoadicionar = findViewById<Button>(R.id.ActivityAddClienteButtonConfirmar)
        val calendarview = findViewById<CalendarView>(R.id.ActivityAddClienteCalendarView)
        var calendardate = ""
        calendarview.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            val dia = dayOfMonth.toString()
            val mes = (month+1).toString()
            val ano = year.toString()
            calendardate = (dia+"-"+mes+"-"+ano)
            title = calendardate
        })
        botaoadicionar.setOnClickListener {
            val addnome = findViewById<TextInputEditText>(R.id.ActivityAddClienteTextInput1)
            val nome: String = addnome.text.toString()
            val addcpf = findViewById<TextInputEditText>(R.id.ActivityAddClienteTextInput2)
            val cpf: String = addcpf.text.toString()
            val addtelefone = findViewById<TextInputEditText>(R.id.ActivityAddClienteTextInput3)
            val telefone: String = addtelefone.text.toString()
            val adddia = findViewById<TextInputEditText>(R.id.ActivityAddClienteTextInput4)
            val dia: String = adddia.text.toString()
            val addvalor = findViewById<TextInputEditText>(R.id.ActivityAddClienteTextInput5)
            val valor: String = addvalor.text.toString()
            val addnotas = findViewById<TextInputEditText>(R.id.ActivityAddClienteTextInput6)
            val notas: String = addnotas.text.toString()
            val clientesDao = db.funcoesdbdao()
            clientesDao.salvaclientes(
                clientes(
                    contrato = calendardate,
                    nome = nome,
                    cpf = cpf,
                    telefone = telefone,
                    data = dia,
                    valor = valor,
                    notas = notas,
                )
            )
            val text = "O Cliente foi adicionado!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }
    private fun startMainActivity(){
        val intent = Intent(applicationContext, MainActivity::class.java)
        val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        intent.removeFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent, bundle)
    }
}