package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment.GroupDetailViewPagerInFAQFragment
import com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment.GroupDetailViewPagerInIntroductionFragment
import com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment.GroupDetailViewPagerInReaderFragment
import com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment.GroupDetailViewPagerInReviewFragment

class GroupDetailViewPager2Adapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {

        return when(position){

            0 -> GroupDetailViewPagerInIntroductionFragment()
            1 -> GroupDetailViewPagerInReaderFragment()
            2 -> GroupDetailViewPagerInReviewFragment()
            else -> GroupDetailViewPagerInFAQFragment()
        }
    }
}