package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.NewExpertAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeNewExpertBinding
import com.start.mindcafeclonepractice.datas.NewExpertData

class HomeNewExpertFragment: BaseFragment() {

    lateinit var binding: FragmentHomeNewExpertBinding
    val mNewExpertList = ArrayList<NewExpertData>()
    lateinit var mNewExpertAdapter: NewExpertAdapter
    var firebase: FirebaseDatabase? = null
    var ref: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_new_expert, container, false)

      firebase = FirebaseDatabase.getInstance()
      ref = FirebaseDatabase.getInstance().getReference("newExpert")

      ref?.addValueEventListener(object : ValueEventListener{
          override fun onDataChange(snapshot: DataSnapshot) {

              if (snapshot.exists()){

                  for (h in snapshot.children){
                      val newExpert = h.getValue(NewExpertData::class.java)
                      mNewExpertList.add(newExpert!!)
                  }
                  mNewExpertAdapter.notifyDataSetChanged()
              }

          }

          override fun onCancelled(error: DatabaseError) {

              Log.d("파이어베이스오류메시지",error.message)
          }

      })

        mNewExpertAdapter = NewExpertAdapter(mNewExpertList, mContext)
        binding.newExpertRecyclerView.adapter = mNewExpertAdapter
        binding.newExpertRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.newExpertRecyclerView.setHasFixedSize(true) //리스스타이템 내용이 달라져도 자동으로 잘 보이도록 화면세팅

        //리싸이클러뷰를 뷰페이저처럼 화면넘김 해주기
//        val snapHelper = PagerSnapHelper()
//        snapHelper.attachToRecyclerView(binding.newExpertRecyclerView)

        //PagerSnapHelper는 중앙정렬로 되어 처음과 마지막 리스트아이템 선택불가 -> GravitySnapHelper로 전환
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(binding.newExpertRecyclerView)


        return binding.root
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}