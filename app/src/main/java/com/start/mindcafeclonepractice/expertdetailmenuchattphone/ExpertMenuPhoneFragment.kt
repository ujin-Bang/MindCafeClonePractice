package com.start.mindcafeclonepractice.expertdetailmenuchattphone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.VoiceDetailActivity
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

        binding.btnVoiceDetail.setOnClickListener {
            startActivity(Intent(mContext, VoiceDetailActivity::class.java))
        }

        FAQClickEvents()

    }

    override fun setValues() {

    }

    //전화택 하단 FAQ클릭 이벤트처리
    fun FAQClickEvents(){


        binding.txtNormal1.setOnClickListener {

                binding.txtNormal1.visibility = View.GONE
                binding.layoutClicked1.visibility = View.VISIBLE
        }

        binding.layoutClicked1.setOnClickListener {

            binding.layoutClicked1.visibility = View.GONE
            binding.txtNormal1.visibility = View.VISIBLE
        }

        binding.txtNormal2.setOnClickListener {

            binding.txtNormal2.visibility = View.GONE
            binding.layoutClicked2.visibility = View.VISIBLE
        }

        binding.layoutClicked2.setOnClickListener {

            binding.layoutClicked2.visibility = View.GONE
            binding.txtNormal2.visibility = View.VISIBLE
        }


        binding.txtNormal3.setOnClickListener {

            binding.txtNormal3.visibility = View.GONE
            binding.layoutClicked3.visibility = View.VISIBLE
        }

        binding.layoutClicked3.setOnClickListener {

            binding.layoutClicked3.visibility = View.GONE
            binding.txtNormal3.visibility = View.VISIBLE
        }


        binding.txtNormal4.setOnClickListener {

            binding.txtNormal4.visibility = View.GONE
            binding.layoutClicked4.visibility = View.VISIBLE
        }

        binding.layoutClicked4.setOnClickListener {

            binding.layoutClicked4.visibility = View.GONE
            binding.txtNormal4.visibility = View.VISIBLE
        }


        binding.txtNormal5.setOnClickListener {

            binding.txtNormal5.visibility = View.GONE
            binding.layoutClicked5.visibility = View.VISIBLE
        }

        binding.layoutClicked5.setOnClickListener {

            binding.layoutClicked5.visibility = View.GONE
            binding.txtNormal5.visibility = View.VISIBLE
        }


    }
}