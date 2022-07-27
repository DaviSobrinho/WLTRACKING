package com.example.wltrackingmobile.fragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wltrackingmobile.R
import com.example.wltrackingmobile.fragments.ChipsFragment
import com.example.wltrackingmobile.fragments.ClientesFragment
import com.example.wltrackingmobile.fragments.RastreadoresFragment
import com.example.wltrackingmobile.fragments.VeiculosFragment
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList

class AdapterTabPager(fragmentManager: FragmentManager, lifecycle: Lifecycle):
FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 ->{
                ClientesFragment()

            }
            1 ->{
                VeiculosFragment()
            }
            2 ->{
                RastreadoresFragment()
            }
            3 ->{
                ChipsFragment()
            }else -> {
                Fragment()
            }
        }
    }
}
