package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.groupexpertdetailfragment.GroupDetailIntroductionFragment
import com.start.mindcafeclonepractice.groupexpertdetailfragment.GroupDetailReviewFragment
import com.start.mindcafeclonepractice.groupexpertdetailfragment.GroupDetailScheduleFragment

class GroupExpertDetailViewPager2Adapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount() = 3


    override fun createFragment(position: Int): Fragment {

        return when(position) {

            0 -> GroupDetailIntroductionFragment()
            1 -> GroupDetailScheduleFragment()
            else -> GroupDetailReviewFragment()
        }
    }
}