package com.start.mindcafeclonepractice.maintopbennerfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.*
import com.start.mindcafeclonepractice.fragments.BaseFragment

class MainTopBenner6Fragment: BaseFragment() {

    lateinit var binding: FragmentMainTopBenner6Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_top_benner6,container,false)
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