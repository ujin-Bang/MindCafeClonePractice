package com.start.mindcafeclonepractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.FragmentExpertFindBinding
import com.start.mindcafeclonepractice.databinding.FragmentHomeBinding

class ExpertFindFragment: BaseFragment() {

    lateinit var binding: FragmentExpertFindBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert_find, container, false)
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