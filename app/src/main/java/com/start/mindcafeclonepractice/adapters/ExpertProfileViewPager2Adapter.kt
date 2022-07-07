package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.viewpager2fragment.Viewpager2ExpertProfile1Fragment
import com.start.mindcafeclonepractice.viewpager2fragment.Viewpager2ExpertProfile2Fragment
import com.start.mindcafeclonepractice.viewpager2fragment.Viewpager2ExpertProfile3Fragment

class ExpertProfileViewPager2Adapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
            return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> Viewpager2ExpertProfile1Fragment()
            1 -> Viewpager2ExpertProfile2Fragment()
            else -> Viewpager2ExpertProfile3Fragment()
        }
    }
}