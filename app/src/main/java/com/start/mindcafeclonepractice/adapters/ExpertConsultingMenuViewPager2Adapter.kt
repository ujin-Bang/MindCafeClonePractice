package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.expertconsultinmenuviewpagerfragment.ExpertConsultingMenuCattFragment
import com.start.mindcafeclonepractice.expertconsultinmenuviewpagerfragment.ExpertConsultingMenuPhoneFragment

class ExpertConsultingMenuViewPager2Adapter(fa: FragmentActivity): FragmentStateAdapter(fa) {



    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> ExpertConsultingMenuCattFragment()
            else -> ExpertConsultingMenuPhoneFragment()
        }
    }
}