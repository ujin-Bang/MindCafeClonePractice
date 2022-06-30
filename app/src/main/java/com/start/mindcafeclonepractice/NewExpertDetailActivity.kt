package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.NewExpertDetailViewPager2Adapter
import com.start.mindcafeclonepractice.databinding.ActivityNewExpertDetailBinding
import com.start.mindcafeclonepractice.datas.NewExpertData

class NewExpertDetailActivity : BaseActivity() {

    lateinit var binding: ActivityNewExpertDetailBinding
    lateinit var data : NewExpertData
    lateinit var mNewExpertDetailProfileViewPagerAdapter : NewExpertDetailViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

//        신규 전문가프래그먼트에서 넘긴 데이터 받아와 활용
        data = intent.getSerializableExtra("data") as NewExpertData

        Glide.with(mContext).load(data.profileImg).into(binding.imgProfile)
        binding.txtIntroduction.text = data.introduction
        binding.txtCoachName.text = data.name
        Glide.with(mContext).load(data.consultingTool1).into(binding.imgConsultingTool1)
        Glide.with(mContext).load(data.consultingTool2).into(binding.imgConsultingTool2)

    mLinearLayoutNewExpertActionbar.visibility = View.VISIBLE
    mLinearLayoutMainActionBar.visibility = View.GONE

        //ViewPager2 어댑터 연결
        mNewExpertDetailProfileViewPagerAdapter = NewExpertDetailViewPager2Adapter(mContext as FragmentActivity)
        binding.newExpertProfileViewPager2.adapter = mNewExpertDetailProfileViewPagerAdapter


        // 뷰페이저와 탭레이아웃을 붙임
        TabLayoutMediator(binding.newExpertProfileTabLayout, binding.newExpertProfileViewPager2) { tab, position ->

            when(position){
                0 -> tab.text = "소개"
                1 -> tab.text = "일정"
                else -> tab.text = "후기"
            }
        }.attach()
    }
}