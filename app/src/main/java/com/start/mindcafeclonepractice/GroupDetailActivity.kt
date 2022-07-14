package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.GroupDetailViewPager2Adapter
import com.start.mindcafeclonepractice.databinding.ActivityGroupDetailBinding
import com.start.mindcafeclonepractice.datas.GroupProgramData
import java.text.DecimalFormat

class GroupDetailActivity : BaseActivity() {

    lateinit var binding: ActivityGroupDetailBinding
    var mData: GroupProgramData? = null
    lateinit var mViewPagerAdapter: GroupDetailViewPager2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_group_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        // 이전 화면 리싸이클러뷰 아이템클릭시 보낸 데이터 받기
        mData = intent.getSerializableExtra("data") as GroupProgramData

        //상속받은 베이스액티비티 안에 액션바 보여주기
        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutGroupDetailActionBar.visibility = View.VISIBLE

        //액션바의 제목 바꾸기
        mTxtGroupDetailActionBarTitle.text = "그룹상세"

        //받아온 데이터 반영
        binding.txtGroupTitle.text = mData?.programTitle
        binding.txtGroupNumberOfParticipants.text = mData?.numberOfParticipants
        binding.txtGroupTime.text = "2022/${mData?.programTime}"
        binding.txtGroupNumberOfParticipants.text = mData?.numberOfParticipants

        val dec = DecimalFormat("#,###")
        val price = mData?.price
        binding.txtGroupConsultingPrice.text = "${dec.format(price)}원"

        Glide.with(mContext).load(mData?.programImg).into(binding.imgGroupConsulting)


        //뷰페이저2 어댑터 연결
        mViewPagerAdapter = GroupDetailViewPager2Adapter(mContext as FragmentActivity)
        binding.groupViewPager2.adapter = mViewPagerAdapter

        //탭레이아웃 + 뷰페이저 연결
        TabLayoutMediator(binding.groupTabLayout, binding.groupViewPager2){ tab, position ->

            when(position){

                0 -> tab.text = "소개"
                1 -> tab.text = "그룹리더"
                2 -> tab.text = "후기"
                else -> tab.text = "FAQ"
            }

        }.attach()

    }
}