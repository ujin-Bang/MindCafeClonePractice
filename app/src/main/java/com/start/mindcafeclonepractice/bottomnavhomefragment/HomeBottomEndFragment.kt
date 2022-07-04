package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeBottomEndBinding

class HomeBottomEndFragment:BaseFragment() {

    lateinit var binding: FragmentHomeBottomEndBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_bottom_end, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        binding.companyInfo.setOnClickListener {

            binding.companyInfo.visibility = View.GONE
            binding.companyClickInfo.visibility = View.VISIBLE
            binding.companyClickInfo2.visibility = View.VISIBLE
        }

        binding.companyClickInfo.setOnClickListener {

            binding.companyClickInfo.visibility = View.GONE
            binding.companyInfo.visibility = View.VISIBLE
            binding.companyClickInfo2.visibility = View.GONE
        }

    }

    override fun setValues() {

    }
}