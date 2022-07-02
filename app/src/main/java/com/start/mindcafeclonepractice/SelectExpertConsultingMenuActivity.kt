package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivitySelectExpertConsultingMenuBinding
import com.start.mindcafeclonepractice.datas.NewExpertData

class SelectExpertConsultingMenuActivity : BaseActivity() {

    lateinit var binding: ActivitySelectExpertConsultingMenuBinding
    lateinit var mData: NewExpertData

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
        binding.txtName.text = mData.name
        binding.txtCoachIntroduction.text = mData.introduction

    }
}