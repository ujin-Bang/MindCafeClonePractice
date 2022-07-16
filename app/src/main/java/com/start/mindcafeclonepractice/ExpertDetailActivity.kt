package com.start.mindcafeclonepractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    var clicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.imgHeart.setOnClickListener {

            clicked = if (!clicked){
                binding.imgHeart.setImageResource(R.drawable.heart_icon_2)
                Toast.makeText(mContext, "전문가를 찜하였습니다.", Toast.LENGTH_SHORT).show()
                true
            } else {
                Glide.with(mContext).load(R.drawable.heart_icon).into(binding.imgHeart)
                Toast.makeText(mContext, "전문가 찜을 취소하였습니다.", Toast.LENGTH_SHORT).show()
                false
            }

        }

        binding.btnSelect.setOnClickListener {

            val myIntent = Intent(mContext,ExpertConsultingMenuChattPhoneActivity::class.java)
            myIntent.putExtra("data",mData)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        // 보내온 데이터 받기 + 사용
        mData = intent.getSerializableExtra("data") as CoachData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = "전문가 프로필"
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