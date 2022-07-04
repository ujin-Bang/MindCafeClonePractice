package com.start.mindcafeclonepractice.expertconsultingmenufragments

import android.annotation.SuppressLint
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

    var selected = false

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

        binding.layout1.setOnClickListener {

            if (!selected){

                binding.layout11.visibility = View.VISIBLE
                binding.layout10.visibility = View.VISIBLE
                binding.layout1.visibility = View.GONE
                selected = true
            }
            else {
                binding.layout11.visibility = View.GONE
                binding.layout10.visibility = View.GONE
                binding.layout1.visibility = View.VISIBLE
                selected = false
            }
        }

        binding.layout10.setOnClickListener {

            if(!selected){
                binding.layout11.visibility = View.VISIBLE
                binding.layout10.visibility = View.VISIBLE
                binding.layout1.visibility = View.GONE
                selected = true
            }
            else {
                binding.layout11.visibility = View.GONE
                binding.layout10.visibility = View.GONE
                binding.layout1.visibility = View.VISIBLE
                selected = false
            }
        }


        binding.layout2.setOnClickListener {

                binding.layout2.visibility = View.GONE
                binding.layout20.visibility = View.VISIBLE
                binding.layout21.visibility = View.VISIBLE
         }

        binding.layout20.setOnClickListener {

            binding.layout20.visibility = View.GONE
            binding.layout2.visibility = View.VISIBLE
            binding.layout21.visibility = View.GONE
        }

        binding.layout3.setOnClickListener {

            binding.layout3.visibility = View.GONE
            binding.layout30.visibility = View.VISIBLE
            binding.layout31.visibility = View.VISIBLE
        }

        binding.layout30.setOnClickListener {

            binding.layout30.visibility = View.GONE
            binding.layout3.visibility = View.VISIBLE
            binding.layout31.visibility = View.GONE
        }

        binding.layout4.setOnClickListener {

            binding.layout4.visibility = View.GONE
            binding.layout40.visibility = View.VISIBLE
            binding.layout41.visibility = View.VISIBLE
        }

        binding.layout40.setOnClickListener {

            binding.layout40.visibility = View.GONE
            binding.layout4.visibility = View.VISIBLE
            binding.layout41.visibility = View.GONE
        }
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