package com.start.mindcafeclonepractice.expertconsultinmenuviewpagerfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ExpertConsultingMenuPhoneRecyclerAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertConsultingMenuPhoneBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuPhoneData

class ExpertConsultingMenuPhoneFragment:BaseFragment() {

    lateinit var binding: FragmentExpertConsultingMenuPhoneBinding
    val mVoiceCoachList= ArrayList<ExpertConsultingMenuPhoneData>()
    lateinit var mAdapter: ExpertConsultingMenuPhoneRecyclerAdapter

    var ref: DatabaseReference? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert_consulting_menu_phone, container, false)

       getPhoneTabDataFromFirebase()

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

    }

    fun getPhoneTabDataFromFirebase(){
        ref = FirebaseDatabase.getInstance().getReference("review").child("1").child("phoneCoaching")
        ref?.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (h in snapshot.children){
                        val phoneData = h.getValue(ExpertConsultingMenuPhoneData::class.java)
                        if (phoneData != null) {
                            mVoiceCoachList.add(phoneData)
                            Log.d("파이어베이스데이터 추가후 메시지",phoneData.toString())
                        }

                    }
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(mContext, error.message, Toast.LENGTH_SHORT).show()
            }

        })
        mAdapter = ExpertConsultingMenuPhoneRecyclerAdapter(mContext,mVoiceCoachList)
        binding.consultingMenuPhoneRecyclerView.adapter = mAdapter
        binding.consultingMenuPhoneRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.consultingMenuPhoneRecyclerView.setHasFixedSize(true)


    }

}