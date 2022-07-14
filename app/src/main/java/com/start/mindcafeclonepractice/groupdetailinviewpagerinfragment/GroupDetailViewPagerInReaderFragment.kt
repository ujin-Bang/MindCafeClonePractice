package com.start.mindcafeclonepractice.groupdetailinviewpagerinfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentGroupdetailViewpagerInReaderBinding
import com.start.mindcafeclonepractice.datas.GroupProgramData

class GroupDetailViewPagerInReaderFragment : BaseFragment() {

    lateinit var binding: FragmentGroupdetailViewpagerInReaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_groupdetail_viewpager_in_reader,
            container,
            false
        )

        binding.imgProfile.setImageResource(R.drawable.trangks)
        binding.imgSallProfile.setImageResource(R.drawable.trangks)
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