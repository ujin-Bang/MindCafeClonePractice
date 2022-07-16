package com.start.mindcafeclonepractice.expertdetailmenuchattphone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertMenuChattBinding
import com.start.mindcafeclonepractice.databinding.FragmentExpertMenuPhoneBinding

class ExpertMenuPhoneFragment:BaseFragment() {

    lateinit var binding: FragmentExpertMenuPhoneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert_menu_phone, container, false)
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