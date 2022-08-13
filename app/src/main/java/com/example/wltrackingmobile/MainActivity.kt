package com.example.wltrackingmobile

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title ="Página Inicial"

        val tabLayout = findViewById<TabLayout>(R.id.ActivityMainTabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.ActivityMainViewPager)
        val adapter = AdapterTabPager(supportFragmentManager, lifecycle)

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
                    val text = "O chip foi adicionado!"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    val recyclerviewchips = findViewById<RecyclerView>(R.id.frament_chips_recyclerView)
                    if (recyclerviewchips != null) {
                        configuraRecyclerView()
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





        criaChip()
        nukechip()
        startAddActivity()

    }
    override fun onResume() {
        super.onResume()

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
    private fun startAddActivity(){
        val botaoinciaaddactivity = findViewById<FloatingActionButton>(R.id.excluir)
        botaoinciaaddactivity.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            val bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            startActivity(intent, bundle)
        }
    }
    fun configuraRecyclerView() {
        val adapter = activitymainchipsadapter(context = this)
        val db = AppDatabase.instancia(this)
        val chips = db.funcoesdbdao()
        adapter.atualiza(chips.buscaTodoschips())
        val recyclerView = findViewById<RecyclerView>(R.id.frament_chips_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}