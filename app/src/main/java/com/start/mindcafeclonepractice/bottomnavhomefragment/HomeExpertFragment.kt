package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.content.Intent
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
import com.start.mindcafeclonepractice.ExpertDetailActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.CoachAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertBinding
import com.start.mindcafeclonepractice.datas.CoachData


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

                Log.d("?????????????????????????????????",error.message)
            }

        } )
        mExpertProfileAdapter = CoachAdapter(mContext,mExpertProfileList)
        binding.expertRecyclerView.adapter = mExpertProfileAdapter
        binding.expertRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.expertRecyclerView.setHasFixedSize(true)

        //?????????????????? ??????????????? ???????????? ????????? ???????????? ?????????
//        val snap = PagerSnapHelper()
//        snap.attachToRecyclerView(binding.expertRecyclerView)

        //?????????????????? ????????? ??????????????? ?????? ??????. gravitysnaphelper ????????????????????? ???????????? ??????!!
        //GravitySnapHelper --> Gravity.START
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(binding.expertRecyclerView)



        return binding.root

    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        recyclerViewItemClickListener()
    }

    override fun setValues() {


    }

    fun recyclerViewItemClickListener(){

        mExpertProfileAdapter.setOnItemClickListener(object : CoachAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: CoachData, position: Int) {

                Intent(mContext, ExpertDetailActivity::class.java).apply {
                    putExtra("data",data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })

    }

}