package com.start.mindcafeclonepractice.bottomcommunityvpfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentCommunityInVp3Binding

class CommunityInVP3Fragment:BaseFragment() {

lateinit var binding: FragmentCommunityInVp3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_community_in_vp3,container,false)
        return binding.root
            }
    override fun setupEvents() {

    }

    override fun setValues() {

    }
}