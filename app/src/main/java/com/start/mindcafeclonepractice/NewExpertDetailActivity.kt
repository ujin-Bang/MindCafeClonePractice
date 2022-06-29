package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.databinding.ActivityNewExpertDetailBinding
import com.start.mindcafeclonepractice.datas.NewExpertData

class NewExpertDetailActivity : BaseActivity() {

    lateinit var binding: ActivityNewExpertDetailBinding
    lateinit var data : NewExpertData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

//        data = intent.getSerializableExtra("detailProfile") as NewExpertData
//
//        Glide.with(mContext).load(data.profileImg).into(binding.imgProfile)
//        binding.txtIntroduction.text = data.introduction
//        binding.txtCoachName.text = data.name
//        Glide.with(mContext).load(data.consultingTool1).into(binding.imgConsultingTool1)
//        Glide.with(mContext).load(data.consultingTool2).into(binding.imgConsultingTool2)


    }
}