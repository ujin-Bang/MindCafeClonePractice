package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.GroupExpertDetailViewPager2Adapter
import com.start.mindcafeclonepractice.databinding.ActivityExpertDetailBinding
import com.start.mindcafeclonepractice.datas.CoachData

class ExpertDetailActivity : BaseActivity() {

    lateinit var binding: ActivityExpertDetailBinding
    lateinit var mData: CoachData
    lateinit var mAdapter: GroupExpertDetailViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        // 보내온 데이터 받기 + 사용
        mData = intent.getSerializableExtra("data") as CoachData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = "                     전문가 프로필"
        Glide.with(mContext).load(mData.profileImg).into(binding.imgExpertPhoto)
        binding.txtExpertName.text = mData.name
        binding.txtExertIntroduction.text = mData.introduction
        Glide.with(mContext).load(mData.meetImg).into(binding.img1)
        Glide.with(mContext).load(mData.phoneImg).into(binding.img2)
        Glide.with(mContext).load(mData.talkImg).into(binding.img3)


        //어댑터 연결
        mAdapter = GroupExpertDetailViewPager2Adapter(mContext as FragmentActivity)
        binding.groupDetailViewPager2.adapter = mAdapter

        //탭레이아웃 + 뷰페이저 연걸
        TabLayoutMediator(binding.groupDetailTabLayout, binding.groupDetailViewPager2){
            tab, position ->

            when(position){
                0 -> tab.text = "소개"
                1 -> tab.text = "일정"
                else -> tab.text = "후기"
            }
        }.attach()

    }
}