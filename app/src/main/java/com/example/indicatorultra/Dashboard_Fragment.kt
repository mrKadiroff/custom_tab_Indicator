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
    private val tabTitles = mutableMapOf(
        "Home" to R.drawable.bir, "Call" to R.drawable.ikki,
        "Chat" to R.drawable.uch
    )
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
        val titles = ArrayList(tabTitles.keys)
        binding.viewPager.adapter = DashboardPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = titles[position]
        }.attach()

        tabTitles.values.forEachIndexed { index, imageResId ->
           val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null)
            as TextView
            textView.setCompoundDrawablesWithIntrinsicBounds(0,imageResId,0,0)
            textView.compoundDrawablePadding = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4f, resources.displayMetrics
            ).roundToInt()
            binding.tabLayout.getTabAt(index)?.customView = textView
        }
    }

}