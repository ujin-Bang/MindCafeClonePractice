package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeMakasPickBinding

class HomeMakasPickFragment : BaseFragment() {

    lateinit var binding: FragmentHomeMakasPickBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_makas_pick, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.txtMacasPick.setOnClickListener {

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("마카's PICK이란?")
            alert.setMessage("마인드카페 커뮤니티 내 전문답변을 \n받은 사연들 " +
                    "중 선택된 사연들입니다.\n \n전문답변 \n고민요약, 고민과 관련된 원인 분석, " +
                    "\n고민에 대한 해결방안과 대처 방안" +
                    "을 더 도움 \n받을 수 있는 측면에 대한전문가들의 " +
                    "답변을 \n받을 수 있습니다.")
            alert.setPositiveButton("확인", null)
            alert.show()

        }


        binding.btnRight.setOnClickListener {


        }
    }

    override fun setValues() {

    }
}