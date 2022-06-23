package com.start.mindcafeclonepractice.bottomnavigationinfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.start.mindcafeclonepractice.MainActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.HomeMainTopBennerViewPagerAdapter
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBinding
import com.start.mindcafeclonepractice.fragments.BaseFragment


class MainTopFragment: BaseFragment() {

    lateinit var binding: FragmentMainTopBinding
    lateinit var mMainTopViewPagerAdapter: HomeMainTopBennerViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_top,container,false)
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

//        배너페이지 어댑터 생성
//        프래그먼트는 부품이고 현재 프래그먼트를 들고 있고 메인액티비티로 변환해서 어댑터에서 필요한 supportFragmentMananer를 가져온다.
        mMainTopViewPagerAdapter = HomeMainTopBennerViewPagerAdapter((mContext as MainActivity).supportFragmentManager)
        binding.mainTopViewPager.adapter = mMainTopViewPagerAdapter


//        val storage = FirebaseStorage.getInstance("gs://mindcafeclone.appspot.com")
//        val storageRef = storage.reference
//        storageRef.child("benner1.png").downloadUrl.addOnSuccessListener { uri -> //이미지 로드 성공시
//            Glide.with(mContext)
//                .load(uri)
//                .into(binding.bennerImg1)
//            Log.d("파이어베이스 응답성공시",uri.toString())
//        }.addOnFailureListener { //이미지 로드 실패시
//            Toast.makeText(mContext,
//                "실패",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }

}



