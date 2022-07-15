package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.databinding.ActivityExpertDetailBinding
import com.start.mindcafeclonepractice.datas.CoachData

class ExpertDetailActivity : BaseActivity() {

    lateinit var binding: ActivityExpertDetailBinding
    lateinit var mData: CoachData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as CoachData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = "                     전문가 프로필"
        Glide.with(mContext).load(mData.profileImg).into(binding.imgExpertPhoto)
        binding.txtExpertName.text = mData.name
        binding.txtExertIntroduction.text = mData.introduction
    }
}