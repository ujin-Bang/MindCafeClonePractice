package com.start.mindcafeclonepractice.bottomcommunityvpfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.CommunityContentCheerRecyclerViewAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentCommunityInVp2Binding
import com.start.mindcafeclonepractice.datas.CommunityContentData

class CommunityInVP2Fragment : BaseFragment() {

    lateinit var binding: FragmentCommunityInVp2Binding
    lateinit var mAdapter: CommunityContentCheerRecyclerViewAdapter

    val mList = ArrayList<CommunityContentData>()
    lateinit var ref : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_community_in_vp2, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setValues()
        setupEvents()

    }

    override fun setupEvents() {

    }

    override fun setValues() {

        getDataFromFirebase()
    }

    fun getDataFromFirebase(){
        ref = FirebaseDatabase.getInstance().getReference("board")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    for (h in snapshot.children){

                        val myData = h.getValue(CommunityContentData::class.java)
                        if (myData != null){
                            mList.add(myData)
                        }

                    }
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        mAdapter = CommunityContentCheerRecyclerViewAdapter(mContext, mList)
        binding.freeRecyclerView.adapter = mAdapter
        binding.freeRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.freeRecyclerView.setHasFixedSize(true)

        //recyclerView 역순으로 출력되도록(최신순으로 정렬)
        val mLayoutManager = LinearLayoutManager(mContext)
        mLayoutManager.reverseLayout = true
        mLayoutManager.stackFromEnd = true

        binding.freeRecyclerView.layoutManager = mLayoutManager



    }
}