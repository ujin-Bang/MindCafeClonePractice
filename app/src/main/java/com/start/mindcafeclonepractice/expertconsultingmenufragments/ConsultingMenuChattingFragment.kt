package com.start.mindcafeclonepractice.expertconsultingmenufragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ConsultingMenuDataRecyclerAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentConsultingMenuChattingBinding
import com.start.mindcafeclonepractice.datas.ConsultingMenuData
import java.util.*
import kotlin.collections.ArrayList

class ConsultingMenuChattingFragment: BaseFragment() {

    lateinit var binding: FragmentConsultingMenuChattingBinding
    val mChattTabList = ArrayList<ConsultingMenuData>()
    lateinit var mChattTabAdapter : ConsultingMenuDataRecyclerAdapter

    var firebase: FirebaseDatabase? = null
    var ref: DatabaseReference? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_consulting_menu_chatting,container, false)

        getFireBaseChattingData()

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

    fun getFireBaseChattingData(){

        firebase = FirebaseDatabase.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("chatt")
        ref!!.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (h in snapshot.children){
                        val chattData = h.getValue(ConsultingMenuData::class.java)
                        mChattTabList.add(chattData!!)
                    }
                    mChattTabAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        mChattTabAdapter = ConsultingMenuDataRecyclerAdapter(mContext, mChattTabList)
        binding.consultingMenuRecyclerView.adapter = mChattTabAdapter
        binding.consultingMenuRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.consultingMenuRecyclerView.setHasFixedSize(true)
    }
}