package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.start.mindcafeclonepractice.adapters.ExpertProfileViewPager2Adapter
import com.start.mindcafeclonepractice.databinding.ActivityExpertProfileBinding
import com.start.mindcafeclonepractice.datas.ReviewData
import com.start.mindcafeclonepractice.viewpager2fragment.Viewpager2ExpertProfile1Fragment

class ExpertProfileActivity : BaseActivity() {

    lateinit var binding: ActivityExpertProfileBinding
    lateinit var mData: ReviewData
    lateinit var mExpertViewPager2Adapter: ExpertProfileViewPager2Adapter
    var click = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        
        binding.imgHeart.setOnClickListener { 
            
            if (!click){
                binding.imgHeart.setImageResource(R.drawable.heart_icon_2)
                click = true

                Toast.makeText(mContext, "전문가를 찜하였습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                binding.imgHeart.setImageResource(R.drawable.heart_icon)
                click = false

                Toast.makeText(mContext, "전문가 찜 취소하였습니다.", Toast.LENGTH_SHORT).show()
            }
            
        }

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