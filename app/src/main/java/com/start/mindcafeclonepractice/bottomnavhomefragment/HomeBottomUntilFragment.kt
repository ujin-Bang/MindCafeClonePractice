package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeBottomUntilBinding

class HomeBottomUntilFragment:BaseFragment() {

    lateinit var binding: FragmentHomeBottomUntilBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_bottom_until, container, false)
        return  binding.root
    }
    override fun setupEvents() {

    }

    override fun setValues() {

    }
}