package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.ExpertProfileViewPager2Adapter
import com.start.mindcafeclonepractice.databinding.ActivityExpertProfileBinding
import com.start.mindcafeclonepractice.datas.ReviewData

class ExpertProfileActivity : BaseActivity() {

    lateinit var binding: ActivityExpertProfileBinding
    lateinit var mData: ReviewData
    lateinit var mExpertViewPager2Adapter: ExpertProfileViewPager2Adapter

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




        //뷰페이저2 어댑터 연결
        mExpertViewPager2Adapter = ExpertProfileViewPager2Adapter(mContext as FragmentActivity)
        binding.expertProfielViewPager2.adapter = mExpertViewPager2Adapter

        //탭 레이아웃 연결
        TabLayoutMediator(binding.expertProfileTabLayout, binding.expertProfielViewPager2){ tab, positon ->

            when(positon){
                0 -> tab.text = "소개"
                1 -> tab.text = "일정"
                else -> tab.text = "후기"
            }

        }.attach()




    }
}