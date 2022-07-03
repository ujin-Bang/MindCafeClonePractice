package com.start.mindcafeclonepractice.expertconsultingmenufragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ConsultingMenuPhoneDataRecylerAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentConsultingMenuPhoneBinding
import com.start.mindcafeclonepractice.datas.ConsultingMenuPhoneData

class ConsultingMenuPhoneFragment: BaseFragment() {

   lateinit var binding: FragmentConsultingMenuPhoneBinding
    val mTabPhoneMenuList = ArrayList<ConsultingMenuPhoneData>()
    lateinit var mTabPhoneMenuAdapter: ConsultingMenuPhoneDataRecylerAdapter

    lateinit var firebase: FirebaseDatabase
    lateinit var ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = DataBindingUtil.inflate(inflater, R.layout.fragment_consulting_menu_phone,container,false)

    getPhonConsultingMenuFromFirebase()

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

    fun getPhonConsultingMenuFromFirebase(){
        firebase = FirebaseDatabase.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("phone")
        ref.addValueEventListener( object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (h in snapshot.children){
                        val phoneData = h.getValue(ConsultingMenuPhoneData::class.java)
                        mTabPhoneMenuList.add(phoneData!!)
                    }
                    mTabPhoneMenuAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        mTabPhoneMenuAdapter = ConsultingMenuPhoneDataRecylerAdapter(mTabPhoneMenuList, mContext)
        binding.consultingMenuRecyclerView.adapter = mTabPhoneMenuAdapter
        binding.consultingMenuRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.consultingMenuRecyclerView.setHasFixedSize(true)
    }
}