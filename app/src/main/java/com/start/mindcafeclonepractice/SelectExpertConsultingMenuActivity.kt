package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.ConsultingMenuViewPagerAdapter
import com.start.mindcafeclonepractice.databinding.ActivitySelectExpertConsultingMenuBinding
import com.start.mindcafeclonepractice.datas.NewExpertData

class SelectExpertConsultingMenuActivity : BaseActivity() {

    lateinit var binding: ActivitySelectExpertConsultingMenuBinding
    lateinit var mData: NewExpertData
    lateinit var mConsultingMenuAdapter: ConsultingMenuViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_select_expert_consulting_menu)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
0
    }

    override fun setValues() {



        mData = intent.getSerializableExtra("data")as NewExpertData


        actionBarCustom()

        //뷰페이저 어댑터에 내가 만든 어댑터 연결
        mConsultingMenuAdapter = ConsultingMenuViewPagerAdapter(mContext as FragmentActivity)
        binding.consultingViewPager.adapter = mConsultingMenuAdapter

        //뷰페이져 + 텝레이아웃 연결
        TabLayoutMediator(binding.consultingMenuTabLayout, binding.consultingViewPager){tab, position ->

            when(position) {
                0 -> tab.text = "채팅"
                else -> tab.text = "전화"
            }

        }.attach()


    }

    fun actionBarCustom(){
        mLinearLayoutNewExpertSelectedConsultingMenu.visibility = View.VISIBLE
        mLinearLayoutMainActionBar.visibility = View.GONE

        mSelectedExpertName.text = mData.name
    }
}