package com.start.mindcafeclonepractice.maintopbennerfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBenner2Binding
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBenner3Binding
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBinding
import com.start.mindcafeclonepractice.fragments.BaseFragment

class MainTopBenner3Fragment: BaseFragment() {

    lateinit var binding: FragmentMainTopBenner3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_top_benner3,container,false)
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