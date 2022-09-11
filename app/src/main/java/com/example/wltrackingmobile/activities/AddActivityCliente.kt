package com.example.wltrackingmobile.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.databinding.ActivityAddClienteBinding
import com.example.wltrackingmobile.model.clientes
import com.example.wltrackingmobile.standardMethods.StandardMethods
import java.text.SimpleDateFormat
import java.util.*

private lateinit var binding: ActivityAddClienteBinding

class AddActivityCliente : AppCompatActivity() {
    val standardMethods = StandardMethods()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClienteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        title = "Adicionar Cliente"
        standardMethods.corrigeTextoCPF(binding.ActivityAddClienteTextInput1)
        configuraBotoesAddActivities()
        salvaCliente()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    private fun configuraBotoesAddActivities(){
        binding.ActivityAddClienteButtonClientes.setOnClickListener{
            standardMethods.iniciaActivity(AddActivityCliente(),this,this)
        }
        binding.ActivityAddClienteButtonVeiculos.setOnClickListener{
            standardMethods.iniciaActivity(AddActivityVeiculo(),this,this)
        }
        binding.ActivityAddClienteButtonRastreadores.setOnClickListener{
            standardMethods.iniciaActivity(AddActivityRastreador(),this,this)
        }
        binding.ActivityAddClienteButtonChips.setOnClickListener{
            standardMethods.iniciaActivity(AddActivityChip(),this,this)
        }
    }
    fun salvaCliente() {


        //Configura o calendário

        binding.ActivityAddClienteCalendarView
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        var calendarDate = currentDate
        title = calendarDate
        binding.ActivityAddClienteCalendarView.setOnDateChangeListener{ view, year, month, dayOfMonth
            ->
            val dia = dayOfMonth.toString()
            val mes = (month+1).toString()
            val ano = year.toString()
            calendarDate = (dia+"-"+mes+"-"+ano)
            title = calendarDate
        }

        /*Pega todos os dados e os salva no banco de dados se possível, do contrário dá um
        alerta ao usuário*/

        binding.ActivityAddClienteButtonConfirmar.setOnClickListener {
            val nome: String = binding.ActivityAddClienteTextInput1.text.toString()
            val cpf: String = binding.ActivityAddClienteTextInput2.text.toString()
            val telefone: String = binding.ActivityAddClienteTextInput3.text.toString()
            val dia: String = binding.ActivityAddClienteTextInput4.text.toString()
            val valor: String = binding.ActivityAddClienteTextInput5.text.toString()
            val notas: String = binding.ActivityAddClienteTextInput6.text.toString()
            val db = AppDatabase.instancia(this)
            val clientesDao = db.funcoesdbdao()
            if(standardMethods.verificaStringVazia(cpf)){
                if( standardMethods.verificaCPFRepetido(cpf,this)) {
                    standardMethods.toast("Já existe um cliente com esse CPF. Por favor" +
                            " insira outro!", applicationContext)
                }else{
                    clientesDao.salvaclientes(
                        clientes(
                            contrato = calendarDate,
                            nome = nome,
                            cpf = cpf,
                            telefone = telefone,
                            data = dia,
                            valor = valor,
                            notas = notas,
                        )
                    )
                    standardMethods.toast("O cliente foi adicionado!", applicationContext)
                    standardMethods.iniciaActivity(MainActivity(),this, this)
                }
            }else{
                standardMethods.toast("Por favor insira um CPF!", applicationContext)
            }

        }
    }

}