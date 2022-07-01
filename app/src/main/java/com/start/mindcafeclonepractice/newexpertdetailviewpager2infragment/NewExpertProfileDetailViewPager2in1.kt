package com.start.mindcafeclonepractice.newexpertdetailviewpager2infragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentNewExpertProfileDetailViewpager2in1Binding
import com.start.mindcafeclonepractice.datas.NewExpertData

class NewExpertProfileDetailViewPager2in1 : BaseFragment() {

    lateinit var NED: NewExpertData

    lateinit var binding: FragmentNewExpertProfileDetailViewpager2in1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_new_expert_profile_detail_viewpager2in1,
            container,
            false
        )


        return binding.root

    }
    override fun setupEvents() {

    }

    override fun setValues() {
        NED = NewExpertData()
        binding.txtCoachingEffect.text = NED.coachingEffect
        binding.txtCoachingScruple.text = NED.coachingScruple
        binding.txtCoachingStyle.text = NED.coachingStyle
    }
}