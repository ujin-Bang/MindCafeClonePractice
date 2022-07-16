package com.start.mindcafeclonepractice.expertdetailmenuchattphone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.Payment2Activity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ExpertMenuChatRecylerAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertMenuChattBinding
import com.start.mindcafeclonepractice.datas.ExpertMenuChattData

class ExpertMenuChattFragment:BaseFragment() {

    lateinit var binding: FragmentExpertMenuChattBinding
    val mList = ArrayList<ExpertMenuChattData>()
    lateinit var mAdapter: ExpertMenuChatRecylerAdapter

    var ref : DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert_menu_chatt, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setValues()
        setupEvents()
    }
    override fun setupEvents() {

        recyclerViewItemClickListener()
    }

    override fun setValues() {

        getChattingMenuDataFromFireBase()
    }

    fun getChattingMenuDataFromFireBase(){

        ref = FirebaseDatabase.getInstance().getReference("chatt")
        ref?.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    for (y in snapshot.children){
                        val myData = y.getValue(ExpertMenuChattData::class.java)

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
        mAdapter = ExpertMenuChatRecylerAdapter(mContext, mList)
        binding.chatRecyclerView.adapter = mAdapter
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.chatRecyclerView.setHasFixedSize(true)
    }

    fun recyclerViewItemClickListener(){
        mAdapter.setOnItemClickListener(object : ExpertMenuChatRecylerAdapter.OnItemClickListener {
            override fun onClick(v: View, data: ExpertMenuChattData, position: Int) {
                Intent(mContext, Payment2Activity::class.java).apply {
                    putExtra("data",data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })
    }
}