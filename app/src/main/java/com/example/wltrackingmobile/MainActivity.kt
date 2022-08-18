package com.example.wltrackingmobile

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.wltrackingmobile.adapters.*
import com.example.wltrackingmobile.database.AppDatabase
import com.example.wltrackingmobile.fragments.adapters.AdapterTabPager
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.chips_rastreadores
import com.example.wltrackingmobile.model.rastreadores
import com.example.wltrackingmobile.model.rastreadores_veiculos
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title ="Página Inicial"
        val tabLayout = findViewById<TabLayout>(R.id.ActivityMainTabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.ActivityMainViewPager)
        val adapter = AdapterTabPager(supportFragmentManager, lifecycle)
//        criachipsrastreador()
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2){ tab, position->
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
        viewPager2?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if(position == 3) {
                    val recyclerviewchips = findViewById<RecyclerView>(R.id.frament_chips_recyclerView)
                    if (recyclerviewchips != null) {
                        configuraRecyclerViewChips()
                    }
                }
                if(position == 2){
                    val recyclerviewveiculos = findViewById<RecyclerView>(R.id.frament_rastreadores_recyclerView)
                    if (recyclerviewveiculos !=null){
                        configuraRecyclerViewRastreadores()
                    }
                }
                if(position == 1){
                    val recyclerviewveiculos = findViewById<RecyclerView>(R.id.frament_veiculos_recyclerView)
                    if (recyclerviewveiculos !=null){
                        configuraRecyclerViewVeiculos()
                    }
                }
                if(position == 0){
                    val recyclerviewclientes = findViewById<RecyclerView>(R.id.frament_clientes_recyclerView)
                    if (recyclerviewclientes != null){
                        configuraRecyclerViewClientes()
                    }
                }
            }
        })
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab){
            }
            override fun onTabUnselected(tab: TabLayout.Tab){
            }
            override fun onTabReselected(tab: TabLayout.Tab){
            }
        })
        nukechip()
        startAddActivity()
    }
    override fun onResume() {
        super.onResume()
    }

    private fun nukechip(){
        val dbn = AppDatabase.instancia(this)
        val botaoatualizar = findViewById<FloatingActionButton>(R.id.atualizar)
        botaoatualizar.setOnClickListener{
            val chipsatualizadao = dbn.funcoesdbdao()
            chipsatualizadao.nukeTable()
        }
    }
    private fun startAddActivity(){
        val botaoinciaaddactivity = findViewById<FloatingActionButton>(R.id.excluir)
        botaoinciaaddactivity.setOnClickListener{
            val intent = Intent(this, AddActivityCliente::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
    fun configuraRecyclerViewChips() {
        val adapter = activitymainchipsadapter(context = this)
        val db = AppDatabase.instancia(this)
        val chips = db.funcoesdbdao()
        adapter.atualiza(chips.buscaTodoschips())
        val recyclerView = findViewById<RecyclerView>(R.id.frament_chips_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    fun configuraRecyclerViewRastreadores(){
        val adapter = activitymainrastreadoresadapter(context = this)
        val db = AppDatabase.instancia(this)
        val rastreadores = db.funcoesdbdao()
        adapter.atualiza(rastreadores.buscaTodosrastreadores())
        val recyclerView = findViewById<RecyclerView>(R.id.frament_rastreadores_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    fun configuraRecyclerViewClientes(){
        val adapter = activitymainclientesadapter(context = this)
        val db = AppDatabase.instancia(this)
        val clientes = db.funcoesdbdao()
        adapter.atualiza(clientes.buscaTodosclientes())
        val recyclerView = findViewById<RecyclerView>(R.id.frament_clientes_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    fun configuraRecyclerViewVeiculos(){
        val adapter = activitymainveiculosadapter(context = this)
        val db = AppDatabase.instancia(this)
        val veiculos = db.funcoesdbdao()
        adapter.atualiza(veiculos.buscaTodosveiculos())
        val recyclerView = findViewById<RecyclerView>(R.id.frament_veiculos_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    private fun criachipsrastreador(){
        val db = AppDatabase.instancia(this)
        val botaoadicionar = findViewById<FloatingActionButton>(R.id.adicionar)
        botaoadicionar.setOnClickListener{
            val chipsrastreadores = db.funcoesdbdao()
            chipsrastreadores.salvaChipsRastreadores(
                chips_rastreadores(
                imeichip = "52",
                imeirastreador = "TesteRas",
                )
            )
        }
    }
    private fun configuraViewChipsRastreadores(){
        val adapter = activitymainchipsrastreadoresadapter(context = this)
        val db = AppDatabase.instancia(this)
        val chipsrastreadores = db.funcoesdbdao()
        adapter.atualiza(chipsrastreadores.findChipsRastreadoresPorImeiChip(imeichip = "52"))
        val recyclerView = findViewById<RecyclerView>(R.id.frament_veiculos_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}