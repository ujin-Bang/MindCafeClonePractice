package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.BaseActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.ActivityNewExpertDetailBinding
import com.start.mindcafeclonepractice.datas.NewExpertData

class NewExpertDetailActivity : BaseActivity() {

    lateinit var binding: ActivityNewExpertDetailBinding
    lateinit var mNewExpertDetail : NewExpertData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

//        mNewExpertDetail = intent.getSerializableExtra("detailProfile") as NewExpertData
//        Glide.with(mContext).load(mNewExpertDetail.profileImg).into(binding.imgProfile)
//        binding.txtIntroduction.text = mNewExpertDetail.introduction


    }
}