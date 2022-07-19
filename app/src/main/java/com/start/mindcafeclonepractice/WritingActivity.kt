package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.start.mindcafeclonepractice.databinding.ActivityWritingBinding
import com.start.mindcafeclonepractice.datas.CommunityTitleData

class WritingActivity : BaseActivity() {

    lateinit var binding: ActivityWritingBinding
    lateinit var mData: CommunityTitleData
    private var authUid: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_writing)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        mTxtWriteUpdate.setOnClickListener {

        }
    }

    override fun setValues() {
        // 보낸 데이터 받기
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

        if(mData.actionBarTitle.length == 4) {
            binding.edtContent.visibility = View.GONE
            binding.layoutFirstPosition.visibility = View.VISIBLE
        }


    }
}