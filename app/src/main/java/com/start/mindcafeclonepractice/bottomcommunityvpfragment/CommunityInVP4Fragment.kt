package com.start.mindcafeclonepractice.bottomcommunityvpfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.CommunityContentTotalRecyclerViewAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentCommunityInVp4Binding
import com.start.mindcafeclonepractice.datas.CommunityContentData

class CommunityInVP4Fragment : BaseFragment() {

    lateinit var binding: FragmentCommunityInVp4Binding
    val mList = ArrayList<CommunityContentData>()
    lateinit var mAdapter: CommunityContentTotalRecyclerViewAdapter
    lateinit var ref : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_community_in_vp4, container, false)
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

        ref = FirebaseDatabase.getInstance().getReference("board")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    for (h in snapshot.children){
                        val myData = h.getValue(CommunityContentData::class.java)
                        mList.add(myData!!)
                    }
                    mAdapter.notifyDataSetChanged()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        mAdapter = CommunityContentTotalRecyclerViewAdapter(mContext, mList)
        binding.totalRecyclerView.adapter = mAdapter
        binding.totalRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.totalRecyclerView.setHasFixedSize(true)

        val mlayoutManager = LinearLayoutManager(mContext)
       mlayoutManager.reverseLayout = true
        mlayoutManager.stackFromEnd = true

        binding.totalRecyclerView.layoutManager = mlayoutManager

    }
}