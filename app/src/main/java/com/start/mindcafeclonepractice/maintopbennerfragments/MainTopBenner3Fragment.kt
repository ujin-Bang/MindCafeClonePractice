package com.start.mindcafeclonepractice.maintopbennerfragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBenner3Binding
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment

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

        binding.imgBanner3.setOnClickListener {

            val myUri = Uri.parse("https://eap.mindcafe.co.kr")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

    }


}