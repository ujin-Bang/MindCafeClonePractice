package com.start.mindcafeclonepractice

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.adapters.ExpertConsultingMenuChattRecyclerAdapter
import com.start.mindcafeclonepractice.adapters.ExpertConsultingMenuViewPager2Adapter
import com.start.mindcafeclonepractice.databinding.ActivityExpertConsultingMenuactivityBinding
import com.start.mindcafeclonepractice.databinding.ActivitySelectExpertConsultingMenuBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuChattData
import com.start.mindcafeclonepractice.datas.ReviewData

class ExpertConsultingMenuActivity : BaseActivity() {

    lateinit var binding: ActivityExpertConsultingMenuactivityBinding
    lateinit var mData: ReviewData
    lateinit var mViewPager2Adapter: ExpertConsultingMenuViewPager2Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_consulting_menuactivity)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutNewExpertSelectedConsultingMenu.visibility = View.VISIBLE
        mData = intent.getSerializableExtra("data") as ReviewData

        mSelectedExpertName.text = mData.coachName


        mViewPager2Adapter = ExpertConsultingMenuViewPager2Adapter(mContext as FragmentActivity)
        binding.consultingMenuViewPager2.adapter = mViewPager2Adapter

        TabLayoutMediator(binding.consultingMenuTabLayout, binding.consultingMenuViewPager2){
            tab, position ->

            when(position){

                0 -> tab.text = "채팅"
                else -> tab.text = "전화"
            }
        }.attach()

    }



}

