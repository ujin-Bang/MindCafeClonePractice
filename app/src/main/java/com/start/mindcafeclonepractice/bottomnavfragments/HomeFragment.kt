package com.start.mindcafeclonepractice.bottomnavfragments

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.MainActivity
import com.start.mindcafeclonepractice.QandAActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        Glide.with(mContext).load("https://www.gcyf.or.kr/data/editor/2003/thumb-2007588ff7d126d8ec550f41e9dc0ddf_1585122800_7305_835x332.jpg")
            .into(binding.imgBanner)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {


            binding.btnQandA.setOnClickListener {
                startActivity(Intent(mContext, QandAActivity::class.java))
            }

        binding.imgBanner.setOnClickListener {

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("국내 최대규모 심리케어센터")
            alert.setMessage("온라인을 통한 100만 회원의 치유 경험을 바탕으로 국내 최대 규모의 오프라인 센터를 오픈하였습니다." +
                    "그 어디에도 없던 온오프라인 병행 심리케어로 심리상담의 새로운 패러다임을 구축했습니다.")
            alert.setPositiveButton("더 알아보기", DialogInterface.OnClickListener { dialog, which ->

                    val myUri = Uri.parse("https://www.naver.com/")
                    val myIntent = Intent(Intent.ACTION_VIEW, myUri)
                    startActivity(myIntent)


            })
            alert.setNegativeButton("닫기",null)
            alert.show()
        }


    }

    override fun setValues() {

    }


}