package com.example.wltrackingmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.wltrackingmobile.fragments.adapters.AdapterTabPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.ActivityMainTabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.ActivityMainViewPager)

        val adapter = AdapterTabPager(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
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
    }
}