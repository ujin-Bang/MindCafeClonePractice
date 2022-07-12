package com.start.mindcafeclonepractice.expertconsultinmenuviewpagerfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.PaymentPhoneActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.VoiceDetailActivity
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

        FAQ()

        recyclerViewItemClickEvent()

        binding.btnVoiceDetail.setOnClickListener {
            startActivity(Intent(mContext, VoiceDetailActivity::class.java))


        }
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

    fun FAQ(){

        binding.txtFAQ1.setOnClickListener {
            binding.txtFAQ1.visibility = View.GONE
            binding.txtFAQ11.visibility = View.VISIBLE
        }
        binding.txtFAQ11.setOnClickListener {
            binding.txtFAQ11.visibility = View.GONE
            binding.txtFAQ1.visibility = View.VISIBLE

        }

        binding.txtFAQ2.setOnClickListener {
            binding.txtFAQ2.visibility = View.GONE
            binding.txtFAQ22.visibility = View.VISIBLE
        }

        binding.txtFAQ22.setOnClickListener {
            binding.txtFAQ22.visibility = View.GONE
            binding.txtFAQ2.visibility = View.VISIBLE
        }

        binding.txtFAQ3.setOnClickListener {
            binding.txtFAQ3.visibility = View.GONE
            binding.txtFAQ33.visibility = View.VISIBLE
        }

        binding.txtFAQ33.setOnClickListener {
            binding.txtFAQ33.visibility = View.GONE
            binding.txtFAQ3.visibility = View.VISIBLE
        }

        binding.txtFAQ4.setOnClickListener {
            binding.txtFAQ4.visibility = View.GONE
            binding.txtFAQ44.visibility = View.VISIBLE
        }

        binding.txtFAQ44.setOnClickListener {
            binding.txtFAQ44.visibility = View.GONE
            binding.txtFAQ4.visibility = View.VISIBLE
        }

        binding.txtFAQ5.setOnClickListener {
            binding.txtFAQ5.visibility = View.GONE
            binding.txtFAQ55.visibility = View.VISIBLE
        }

        binding.txtFAQ55.setOnClickListener {
            binding.txtFAQ55.visibility = View.GONE
            binding.txtFAQ5.visibility = View.VISIBLE
        }
    }

    //리싸이클러뷰 아이템 클릭 이벤트처리 : 클릭된 아이템에 데이터 담아서 다른 화면(결제화면)으로 넘기기
    fun recyclerViewItemClickEvent(){

       mAdapter.setOnItemClickListener(object : ExpertConsultingMenuPhoneRecyclerAdapter.OnItemClickListener {
           override fun onItemClick(v: View, data: ExpertConsultingMenuPhoneData, position: Int) {
               Intent(activity,PaymentPhoneActivity::class.java).apply {

                   putExtra("data",data)
                   addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

               }.run { startActivity(this) }

           }

       })

    }

}