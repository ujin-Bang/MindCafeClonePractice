package com.start.mindcafeclonepractice.expertconsultinmenuviewpagerfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ExpertConsultingMenuChattRecyclerAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertConsultingMenuChattBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuChattData

class ExpertConsultingMenuCattFragment:BaseFragment() {

    lateinit var binding: FragmentExpertConsultingMenuChattBinding

    val mTherapyList = ArrayList<ExpertConsultingMenuChattData>()
    lateinit var mAdapter : ExpertConsultingMenuChattRecyclerAdapter

    var ref: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert_consulting_menu_chatt, container,false)

        getTherapyListFromFirebase()
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

    }

    fun getTherapyListFromFirebase(){
        ref = FirebaseDatabase.getInstance().getReference("review").child("1").child("textTherapy")
        ref?.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        for (h in snapshot.children){
                            val therapyData = h.getValue(ExpertConsultingMenuChattData::class.java)
                            mTherapyList.add(therapyData!!)
                        }
                        mAdapter.notifyDataSetChanged()
                    }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.d("파이어베이스에러메시지:",error.message)
            }

        })
        mAdapter = ExpertConsultingMenuChattRecyclerAdapter(mContext,mTherapyList)
        binding.consultingMenuChattingRecyclerView.adapter = mAdapter
        binding.consultingMenuChattingRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.consultingMenuChattingRecyclerView.setHasFixedSize(true)

    }
}