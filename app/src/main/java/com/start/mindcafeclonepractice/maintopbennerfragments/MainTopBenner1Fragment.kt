package com.start.mindcafeclonepractice.maintopbennerfragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBenner1Binding
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBinding
import com.start.mindcafeclonepractice.fragments.BaseFragment

class MainTopBenner1Fragment: BaseFragment() {

    lateinit var binding: FragmentMainTopBenner1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_top_benner1,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.imgBanner1.setOnClickListener {

            val myUri = Uri.parse("https://www.mindcafe.co.kr")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

    }


}