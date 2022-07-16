package com.start.mindcafeclonepractice.groupexpertdetailfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentGroupDetailIntroductionBinding
import com.start.mindcafeclonepractice.databinding.FragmentGroupDetailReviewBinding
import com.start.mindcafeclonepractice.databinding.FragmentGroupDetailScheduleBinding

class GroupDetailReviewFragment: BaseFragment() {

    lateinit var binding: FragmentGroupDetailReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_group_detail_review, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setValues()
        setupEvents()

    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}