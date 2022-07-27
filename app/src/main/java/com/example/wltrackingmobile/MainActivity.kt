package com.example.wltrackingmobile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.wltrackingmobile.adapters.activitymainchipsadapter
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.fragments.adapters.AdapterTabPager
import com.example.wltrackingmobile.model.chips
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputLayout

public class MainActivity : AppCompatActivity(){

    val adapter = activitymainchipsadapter(context = this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.ActivityMainTabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.ActivityMainViewPager)
        val recyclerView = findViewById<RecyclerView>(R.id.frament_chips_recyclerView)
        val adapter = AdapterTabPager(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager2,){tab,position->
            when(position){
                0 ->{
                    tab.text="Cliente"
                    tab.setIcon(R.drawable.ic_action_cliente)

                }
                1 ->{
                    tab.text="Veículo"
                    tab.setIcon(R.drawable.ic_action_veiculo)
                }
                2 ->{
                    tab.text="Rastreador"
                    tab.setIcon(R.drawable.ic_action_rastreador)
                }
                3 ->{
                    tab.text="Chip"
                    tab.setIcon(R.drawable.ic_action_chip)

                }
            }
        }.attach()
        criaChip()
        nukechip()
        configuratablayoutchange()

    }
        override fun onResume() {
            super.onResume()
            val db = AppDatabase.instancia(this)
            val chips = db.funcoesdbdao()
            adapter.atualiza(chips.buscaTodoschips())

        }
    private fun criaChip() {
        val db = AppDatabase.instancia(this)

        val botaoadicionar = findViewById<FloatingActionButton>(R.id.adicionar)
        botaoadicionar.setOnClickListener {

            val addimei = findViewById<TextInputLayout>(R.id.pesquisar)
            val imei: String = addimei.editText?.text.toString()


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
    private fun nukechip(){
        val dbn = AppDatabase.instancia(this)
        val botaoatualizar = findViewById<FloatingActionButton>(R.id.atualizar)
        botaoatualizar.setOnClickListener{
            val chipsatualizadao = dbn.funcoesdbdao()
            chipsatualizadao.nukeTable()
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.frament_chips_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    private fun configuratablayoutchange(){
        val tablayoutchange = findViewById<TabLayout>(R.id.ActivityMainTabLayout)
        tablayoutchange.setOnClickListener{
            if(tablayoutchange.selectedTabPosition == 3) {
                configuraRecyclerView()
            }
        }
    }
}