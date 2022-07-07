package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityReviewDetailBinding
import com.start.mindcafeclonepractice.datas.ReviewData

class ReviewDetailActivity : BaseActivity() {

    lateinit var binding: ActivityReviewDetailBinding

    lateinit var mReviewData : ReviewData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_review_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        //베이스 액티비티 멤버변수로 만들어 놓은 액션바 가져와서 보여주기
        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutReviewDetailActionBar.visibility = View.VISIBLE

        //리뷰 프래그먼트에서 putExtra로 보낸 리싸이클러뷰 아이템 받아오기
        mReviewData = intent.getSerializableExtra("data") as ReviewData

        //액션바 제목 받아온 데이터로 표현
        mReviewTitle.text = mReviewData.purchaseProduct



    }
}