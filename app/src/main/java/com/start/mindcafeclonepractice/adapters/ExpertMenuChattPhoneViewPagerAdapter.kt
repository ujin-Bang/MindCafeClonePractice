package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.expertdetailmenuchattphone.ExpertMenuChattFragment
import com.start.mindcafeclonepractice.expertdetailmenuchattphone.ExpertMenuPhoneFragment

class ExpertMenuChattPhoneViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {


    override fun getItemCount() = 2



    override fun createFragment(position: Int): Fragment {

        return when(position){

            0 -> ExpertMenuChattFragment()
            else -> ExpertMenuPhoneFragment()

        }
    }
}