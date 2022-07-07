package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.databinding.ActivityExpertProfileBinding
import com.start.mindcafeclonepractice.datas.ReviewData

class ExpertProfileActivity : BaseActivity() {

    lateinit var binding: ActivityExpertProfileBinding
    lateinit var mData: ReviewData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("review") as ReviewData

        binding.txtContent.text = mData.coachInstruction
        binding.txtName.text = mData.coachName
        Glide.with(mContext).load(mData.profileImg).into(binding.imgProfile)
        Glide.with(mContext).load(mData.solutionImg).into(binding.imgConsultingTool1)
        Glide.with(mContext).load(mData.solutionImg2).into(binding.imgConsultingTool2)

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutNewExpertActionbar.visibility = View.VISIBLE


    }
}