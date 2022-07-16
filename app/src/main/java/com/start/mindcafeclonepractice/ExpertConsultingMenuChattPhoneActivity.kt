package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.ExpertMenuChattPhoneViewPagerAdapter
import com.start.mindcafeclonepractice.databinding.ActivityExpertConsultingMenuChattPhoneBinding
import com.start.mindcafeclonepractice.datas.CoachData

class ExpertConsultingMenuChattPhoneActivity : BaseActivity() {

    lateinit var binding: ActivityExpertConsultingMenuChattPhoneBinding
    lateinit var mData: CoachData
    lateinit var mViewPager2Adapter: ExpertMenuChattPhoneViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_consulting_menu_chatt_phone)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as CoachData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = "${mData.name}"

        //뷰페이저에 만들어 놓은 어댑터 연결
        mViewPager2Adapter = ExpertMenuChattPhoneViewPagerAdapter(mContext as FragmentActivity)
        binding.menuViewPager.adapter = mViewPager2Adapter

        //텝레이아웃 + 뷰페이저 연결
        TabLayoutMediator(binding.menuTabLayout, binding.menuViewPager){
            tab, position ->

            when(position){
                0 -> tab.text = "채팅"
                else -> tab.text = "전화"
            }
        }.attach()

    }
}