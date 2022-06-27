package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.CoachAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertBinding
import com.start.mindcafeclonepractice.datas.CoachData
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator


class HomeExpertFragment: BaseFragment() {

    lateinit var binding: FragmentExpertBinding
    val mExpertProfileList = ArrayList<CoachData>()
    var firebase : FirebaseDatabase? = null
    var ref : DatabaseReference? = null
    lateinit var mExpertProfileAdapter: CoachAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert, container, false)

        firebase = FirebaseDatabase.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("coachProfile")

        ref?.addValueEventListener( object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot!!.exists()){
                    for (h in snapshot.children){
                        val coachPforile =  h.getValue(CoachData::class.java)

                        mExpertProfileList.add(coachPforile!!)
                    }

                    mExpertProfileAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.d("파이어베이스에러메시지",error.message)
            }

        } )
        mExpertProfileAdapter = CoachAdapter(mContext,mExpertProfileList)
        binding.expertRecyclerView.adapter = mExpertProfileAdapter
        binding.expertRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.expertRecyclerView.setHasFixedSize(true)

        //리싸이클러뷰 자연스럽게 넘김효과 페이지 중앙으로 정렬됨
//        val snap = PagerSnapHelper()
//        snap.attachToRecyclerView(binding.expertRecyclerView)

        //리싸이클러뷰 페이지 자연스럽게 넘김 효과. gravitysnaphelper 의존성추가해서 사용해서 해결!!
        //GravitySnapHelper --> Gravity.START
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(binding.expertRecyclerView)



        return binding.root

    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun setupEvents() {

    }

    override fun setValues() {



    }

}