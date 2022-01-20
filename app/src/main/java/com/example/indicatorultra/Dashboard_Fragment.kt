package com.example.indicatorultra

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.indicatorultra.databinding.FragmentDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.roundToInt


class Dashboard_Fragment : Fragment() {


    private lateinit var binding: FragmentDashboardBinding
    private val tabTitles = arrayListOf("Ogohlantiruvchi","Imtiyozli","Taqiqlovchi","Buyuruvchi")
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(layoutInflater)

        setUpTablayoutWithViewPager()

        return binding.root
    }

    private fun setUpTablayoutWithViewPager() {
        binding.viewPager.adapter = DashboardPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        for (i in 0..4) {

           val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null)
            as TextView

            binding.tabLayout.getTabAt(i)?.customView = textView
        }
    }

}