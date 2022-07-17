package com.start.mindcafeclonepractice.expertdetailmenuchattphone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.Payment22Activity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.VoiceDetailActivity
import com.start.mindcafeclonepractice.adapters.ExpertMenuPhoneRecylerAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertMenuPhoneBinding
import com.start.mindcafeclonepractice.datas.ExpertMenuPhoneData

class ExpertMenuPhoneFragment:BaseFragment() {

    lateinit var binding: FragmentExpertMenuPhoneBinding
    val mList = ArrayList<ExpertMenuPhoneData>()
    lateinit var mAdapter: ExpertMenuPhoneRecylerAdapter

    lateinit var ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert_menu_phone, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setValues()
        setupEvents()
    }
    override fun setupEvents() {

        binding.btnVoiceDetail.setOnClickListener {
            startActivity(Intent(mContext, VoiceDetailActivity::class.java))
        }

        FAQClickEvents()

        recyclerViewItemClickListener()

    }

    override fun setValues() {

        getPhoneDataFromFireBaseDB()
    }

    //전화택 하단 FAQ클릭 이벤트처리
    fun FAQClickEvents(){


        binding.txtNormal1.setOnClickListener {

                binding.txtNormal1.visibility = View.GONE
                binding.layoutClicked1.visibility = View.VISIBLE
        }

        binding.layoutClicked1.setOnClickListener {

            binding.layoutClicked1.visibility = View.GONE
            binding.txtNormal1.visibility = View.VISIBLE
        }

        binding.txtNormal2.setOnClickListener {

            binding.txtNormal2.visibility = View.GONE
            binding.layoutClicked2.visibility = View.VISIBLE
        }

        binding.layoutClicked2.setOnClickListener {

            binding.layoutClicked2.visibility = View.GONE
            binding.txtNormal2.visibility = View.VISIBLE
        }


        binding.txtNormal3.setOnClickListener {

            binding.txtNormal3.visibility = View.GONE
            binding.layoutClicked3.visibility = View.VISIBLE
        }

        binding.layoutClicked3.setOnClickListener {

            binding.layoutClicked3.visibility = View.GONE
            binding.txtNormal3.visibility = View.VISIBLE
        }


        binding.txtNormal4.setOnClickListener {

            binding.txtNormal4.visibility = View.GONE
            binding.layoutClicked4.visibility = View.VISIBLE
        }

        binding.layoutClicked4.setOnClickListener {

            binding.layoutClicked4.visibility = View.GONE
            binding.txtNormal4.visibility = View.VISIBLE
        }


        binding.txtNormal5.setOnClickListener {

            binding.txtNormal5.visibility = View.GONE
            binding.layoutClicked5.visibility = View.VISIBLE
        }

        binding.layoutClicked5.setOnClickListener {

            binding.layoutClicked5.visibility = View.GONE
            binding.txtNormal5.visibility = View.VISIBLE
        }


    }

    //파이어베이스 연결 데이터 리스트에 담기
    fun getPhoneDataFromFireBaseDB(){

        ref = FirebaseDatabase.getInstance().getReference("phone")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    for (h in snapshot.children){
                        val phoneData = h.getValue(ExpertMenuPhoneData::class.java)

                        if (phoneData != null){

                            mList.add(phoneData)

                        }
                    }
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        mAdapter = ExpertMenuPhoneRecylerAdapter(mContext, mList)
        binding.phoneRecyclerView.adapter = mAdapter
        binding.phoneRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.phoneRecyclerView.setHasFixedSize(true)


    }

    //리싸이클러뷰 아이템 클릭이벤트
    fun recyclerViewItemClickListener(){

        mAdapter.setOnItemClickListener(object : ExpertMenuPhoneRecylerAdapter.OnItemClickListener{
            override fun onClick(v: View, data: ExpertMenuPhoneData, position: Int) {
                Intent(mContext, Payment22Activity::class.java).apply {
                    putExtra("data",data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })
    }
}