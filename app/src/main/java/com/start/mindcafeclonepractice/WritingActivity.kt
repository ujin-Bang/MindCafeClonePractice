package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.adapters.WorryRecyclerAdapter
import com.start.mindcafeclonepractice.databinding.ActivityWritingBinding
import com.start.mindcafeclonepractice.datas.CommunityTitleData
import com.start.mindcafeclonepractice.datas.WorryData
import com.start.mindcafeclonepractice.datas.WorryData2

class WritingActivity : BaseActivity() {

    lateinit var binding: ActivityWritingBinding
    lateinit var mData: CommunityTitleData
    private var authUid: String? = null

    val mList = ArrayList<WorryData>()
    lateinit var mAdapter: WorryRecyclerAdapter
    var ref: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_writing)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        //사연 보내기 버튼 클릭시 => 입력한 텍스트, 받아온 제목, 로그인 uid
        mTxtWriteUpdate.setOnClickListener {

            val inputEdtText = binding.edtContent.text.toString()
            val mTitle = mData.title
            //보낸 로그인 UID받기
            if(intent.hasExtra("auth")){

                authUid = intent.getStringExtra("auth")

            }

            ref = FirebaseDatabase.getInstance().getReference()

            val dataInput = WorryData2( mTitle, inputEdtText, authUid!!)
            ref?.child("board")?.push()?.setValue(dataInput)


        }


    }

    override fun setValues() {
        // 보내온 데이터 받기
        mData = intent.getSerializableExtra("data") as CommunityTitleData

        //보낸 로그인 UID받기
        if(intent.hasExtra("auth")){

            authUid = intent.getStringExtra("auth")

        }

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutWritingActionBar.visibility = View.VISIBLE

        mTxtPhrase.text = mData.actionBarTitle

        //EditText의 문구에 아무것도 적혀 있지 않은 상태라면 포커스를 EditText에 위치시켜주세요.
       val inputText =  binding.edtContent
        if ("".equals(inputText.text.toString())){
            inputText.requestFocus()
        }

        //받아온 데이터 안에 문구를 EditText의 힌트로 적용
        binding.edtContent.hint = mData.edtHint

        //받아온 데이터의 액션바 타이틀 길이가 4이면 실행
        if(mData.actionBarTitle.length == 4) {
            binding.edtContent.visibility = View.GONE
            binding.layoutFirstPosition.visibility = View.VISIBLE
            mTxtWriteUpdate.visibility = View.GONE
            mTxtWriteNextActionBar.visibility = View.VISIBLE
        }


    }

//    fun getWorryDataFromFirebase(){
//
//        ref = FirebaseDatabase.getInstance().getReference("community")
//        ref?.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()){
//                    for (h in snapshot.children){
//                        val myWorryData = h.getValue(WorryData::class.java)
//                        mList.add(myWorryData!!)
//                    }
//                }
//                mAdapter.notifyDataSetChanged()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//        mAdapter = WorryRecyclerAdapter(mContext, mList)
//        binding.worryListRecyclerView.adapter = mAdapter
//        binding.worryListRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
//        binding.worryListRecyclerView.setHasFixedSize(true)
//    }
}