package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.start.mindcafeclonepractice.maintopbennerfragments.*

class HomeMainTopBennerViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount() = 7

    override fun getItem(position: Int): Fragment {
        return when(position){

            0 -> MainTopBenner1Fragment()
            1 -> MainTopBenner2Fragment()
            2 -> MainTopBenner3Fragment()
            3 -> MainTopBenner4Fragment()
            4 -> MainTopBenner5Fragment()
            5 -> MainTopBenner6Fragment()
            else -> MainTopBenner7Fragment()

        }
    }
}