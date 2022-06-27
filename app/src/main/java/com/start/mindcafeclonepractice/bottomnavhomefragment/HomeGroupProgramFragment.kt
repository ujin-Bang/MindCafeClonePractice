package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeGroupProgramBinding

class HomeGroupProgramFragment: BaseFragment() {

    lateinit var binding: FragmentHomeGroupProgramBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_group_program, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnGroupProgramInfo.setOnClickListener {

            val alert = AlertDialog.Builder(mContext)
                alert.setTitle("그룹프로그램이란?")
                alert.setMessage("그룹 테라피와 그룹 코칭이 통합 된 소규모 그룹(4~10명)으로 진행되는 프로그램입니다.\n" +
                        "그룹프로그램을 이끄는 그룹 리더와 비슷한 고민이나 고통을 겪는 참가자들로 구성됩니다." +
                        "\n\n1.그룹 테라피\n상담사가 리더이고 심리치유를 목적으로 하는 그룹 테라피\n\n2. 그룹코칭" +
                        "\n코치가 리더이고 꿈과 목표를 목적으로 하는 그룹테라피")
                alert.setPositiveButton("확인",null)
                alert.show()
        }

    }

    override fun setValues() {

    }


}