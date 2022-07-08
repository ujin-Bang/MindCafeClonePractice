package com.start.mindcafeclonepractice.viewpager2fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentViepager2ExpertProfile1Binding
import com.start.mindcafeclonepractice.datas.ReviewData

class Viewpager2ExpertProfile1Fragment: BaseFragment() {

    lateinit var binding: FragmentViepager2ExpertProfile1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_viepager2_expert_profile_1, container, false)

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