package com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentGroupdetailViewpagerInFaqBinding

class GroupDetailViewPagerInFAQFragment:BaseFragment() {

    lateinit var binding: FragmentGroupdetailViewpagerInFaqBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_groupdetail_viewpager_in_faq, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        FAQ()

    }

    override fun setValues() {

     }

    fun FAQ(){
        binding.faq1.setOnClickListener {
            binding.faq1.visibility = View.GONE
            binding.faq11.visibility = View.VISIBLE
        }

        binding.faq11.setOnClickListener {
            binding.faq11.visibility = View.GONE
            binding.faq1.visibility = View.VISIBLE
        }

        binding.faq2.setOnClickListener {
            binding.faq2.visibility = View.GONE
            binding.faq22.visibility = View.VISIBLE
        }

        binding.faq22.setOnClickListener {
            binding.faq22.visibility = View.GONE
            binding.faq2.visibility = View.VISIBLE
        }

        binding.faq3.setOnClickListener {
            binding.faq3.visibility = View.GONE
            binding.faq33.visibility = View.VISIBLE
        }

        binding.faq33.setOnClickListener {
            binding.faq33.visibility = View.GONE
            binding.faq3.visibility = View.VISIBLE
        }

        binding.faq4.setOnClickListener {
            binding.faq4.visibility = View.GONE
            binding.faq44.visibility = View.VISIBLE
        }

        binding.faq44.setOnClickListener {
            binding.faq44.visibility = View.GONE
            binding.faq4.visibility = View.VISIBLE
        }
    }
}