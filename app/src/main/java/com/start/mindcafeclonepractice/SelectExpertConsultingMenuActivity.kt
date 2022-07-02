package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
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

        mConsultingMenuAdapter = ConsultingMenuViewPagerAdapter(mContext as FragmentActivity)
        binding.consultingViewPager.adapter = mConsultingMenuAdapter

    }

    fun actionBarCustom(){
        mLinearLayoutNewExpertSelectedConsultingMenu.visibility = View.VISIBLE
        mLinearLayoutMainActionBar.visibility = View.GONE

        mSelectedExpertName.text = mData.name
    }
}