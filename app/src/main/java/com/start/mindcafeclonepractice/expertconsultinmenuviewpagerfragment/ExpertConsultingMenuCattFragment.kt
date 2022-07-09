package com.start.mindcafeclonepractice.expertconsultinmenuviewpagerfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.ChattDetailActivity
import com.start.mindcafeclonepractice.PaymentActivity
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

        binding.btnDetailChatt.setOnClickListener {
            val myIntent = Intent(mContext, ChattDetailActivity::class.java)
            startActivity(myIntent)
        }

        chattTabRecyclerItemClickListener()
    }

    override fun setValues() {


    }

    //파이어 베이스 데이터 가져오기
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

    //리싸이클러뷰 아이템클릭 이벤트 처리 : 클릭된 아이템의 데이터 다른 액티비티(결제화면)로 넘기기
    fun chattTabRecyclerItemClickListener(){

        mAdapter.setOnItemClickListener(object : ExpertConsultingMenuChattRecyclerAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: ExpertConsultingMenuChattData, pos: Int) {
                Intent(activity,PaymentActivity::class.java).apply {
                    putExtra("data", data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })

    }
}