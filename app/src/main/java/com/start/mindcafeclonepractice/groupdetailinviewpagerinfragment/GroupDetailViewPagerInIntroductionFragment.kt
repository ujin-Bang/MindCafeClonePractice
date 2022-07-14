package com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentGroupdetailViewpagerInIntroductionBinding
import com.start.mindcafeclonepractice.datas.GroupProgramData

class GroupDetailViewPagerInIntroductionFragment : BaseFragment() {

    lateinit var binding: FragmentGroupdetailViewpagerInIntroductionBinding
    var mData: GroupProgramData? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_groupdetail_viewpager_in_introduction,
            container,
            false
        )

//        Glide.with(mContext).load(mData?.programImg).into(binding.imgGroupEmotion : 데이터 받아와지지않음

//          인터넷상의 주소로 대체
        Glide.with(mContext)
            .load("https://scienceoflove.co.kr/wp-content/uploads/2016/07/sol099_illu_06.png")
            .into(binding.imgGroupEmotion)
        Glide.with(mContext)
            .load("https://cdn.pixabay.com/photo/2014/08/08/20/55/worried-girl-413690_1280.jpg")
            .into(binding.imgGroupEmotion2)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }


}