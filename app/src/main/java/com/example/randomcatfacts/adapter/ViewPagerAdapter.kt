package com.example.randomcatfacts.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.randomcatfacts.presentation.CatFacts
import com.example.randomcatfacts.presentation.FavoriteFacts

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CatFacts()
            1 -> FavoriteFacts()
            else -> Fragment()
        }
    }
}