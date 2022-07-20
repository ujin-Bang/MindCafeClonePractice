package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.bottomcommunityvpfragment.CommunityInVP1Fragment
import com.start.mindcafeclonepractice.bottomcommunityvpfragment.CommunityInVP2Fragment
import com.start.mindcafeclonepractice.bottomcommunityvpfragment.CommunityInVP3Fragment
import com.start.mindcafeclonepractice.bottomcommunityvpfragment.CommunityInVP4Fragment
import com.start.mindcafeclonepractice.databinding.FragmentCommunityInVp1Binding

class CommunityViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> CommunityInVP1Fragment()
            1 -> CommunityInVP2Fragment()
            2 -> CommunityInVP3Fragment()
            else -> CommunityInVP4Fragment()
        }
    }
}