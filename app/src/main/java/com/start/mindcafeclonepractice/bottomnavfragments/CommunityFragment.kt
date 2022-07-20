package com.start.mindcafeclonepractice.bottomnavfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.CommunityViewPagerAdapter
import com.start.mindcafeclonepractice.databinding.FragmentCommunityBinding

class CommunityFragment: BaseFragment() {

    lateinit var binding: FragmentCommunityBinding
    lateinit var mVPA : CommunityViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_community, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {

    }

    override fun setValues() {

        viewPager2AndAdapterAndTablayout()
    }

    fun viewPager2AndAdapterAndTablayout(){
        mVPA = CommunityViewPagerAdapter(mContext as FragmentActivity)
        binding.communityViewPager2.adapter = mVPA

        TabLayoutMediator(binding.communityTablyout, binding.communityViewPager2){
            tab, position ->

            when(position){
                0 -> tab.text = "응원사연"
                1 -> tab.text = "자유사연"
                2 -> tab.text = "고민사연"
                else -> tab.text = "모든사연"

            }
        }.attach()
    }


}