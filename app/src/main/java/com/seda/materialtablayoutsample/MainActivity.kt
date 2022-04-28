package com.seda.materialtablayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.seda.materialtablayoutsample.databinding.ActivityMainBinding
import com.seda.materialtablayoutsample.databinding.FragmentBirinciBinding

class MainActivity : AppCompatActivity() {
    private val fragmentlist =ArrayList<Fragment>()
    private val fragmentBaslikListesi =ArrayList<String>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentlist.add(BirinciFragment())
        fragmentlist.add(ikinciFragment())
        fragmentlist.add(ucuncuFragment())

        val adapter = MyviewAdapter(this)
        binding.viewpager2.adapter =adapter
        fragmentBaslikListesi.add("Bir")
        fragmentBaslikListesi.add("İki")
        fragmentBaslikListesi.add("üç")
        TabLayoutMediator(binding.tablayout,binding.viewpager2){tab,position ->
            tab.setText(fragmentBaslikListesi[position])

        }.attach()

    }
    inner class MyviewAdapter(fragmentActivity:FragmentActivity): FragmentStateAdapter(fragmentActivity)
    {
        override fun getItemCount(): Int {
         return fragmentlist.size

        }

        override fun createFragment(position: Int): Fragment {

  return fragmentlist[position]
        }

    }

}