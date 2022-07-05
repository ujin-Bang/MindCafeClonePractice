package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.NoticeActivity2
import com.start.mindcafeclonepractice.NoticePsychologicalTestActivity
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

        binding.btnNotice.setOnClickListener {

            val myIntent = Intent(mContext , NoticePsychologicalTestActivity::class.java)
            startActivity(myIntent)
        }


        binding.btnNotice2.setOnClickListener {
            startActivity(Intent(mContext,NoticeActivity2::class.java))
        }
    }

    override fun setValues() {

    }
}