package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.databinding.FragmentConsultingMenuChattingBinding
import com.start.mindcafeclonepractice.databinding.FragmentConsultingMenuPhoneBinding
import com.start.mindcafeclonepractice.expertconsultingmenufragments.ConsultingMenuChattingFragment
import com.start.mindcafeclonepractice.expertconsultingmenufragments.ConsultingMenuPhoneFragment

class ConsultingMenuViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> ConsultingMenuChattingFragment()
            else -> ConsultingMenuPhoneFragment()
        }
    }
}