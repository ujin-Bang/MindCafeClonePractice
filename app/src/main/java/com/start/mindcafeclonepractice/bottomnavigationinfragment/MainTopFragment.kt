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
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.FragmentMainTopBinding
import com.start.mindcafeclonepractice.fragments.BaseFragment


class MainTopFragment: BaseFragment() {

    lateinit var binding: FragmentMainTopBinding

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

        val storage = FirebaseStorage.getInstance("gs://mindcafeclone.appspot.com")
        val storageRef = storage.reference
        storageRef.child("Benner1.png").downloadUrl.addOnSuccessListener { uri -> //이미지 로드 성공시
            Glide.with(mContext)
                .load(uri)
                .into(binding.bennerImg1)
            Log.d("파이어베이스 응답성공시",uri.toString())
        }.addOnFailureListener { //이미지 로드 실패시
            Toast.makeText(mContext,
                "실패",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}



