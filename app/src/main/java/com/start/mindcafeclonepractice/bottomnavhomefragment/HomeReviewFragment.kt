package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.NewExpertDetailActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.ReviewDetailActivity
import com.start.mindcafeclonepractice.adapters.NewExpertAdapter
import com.start.mindcafeclonepractice.adapters.ReviewAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeReviewBinding
import com.start.mindcafeclonepractice.datas.NewExpertData
import com.start.mindcafeclonepractice.datas.ReviewData

class HomeReviewFragment: BaseFragment() {

    lateinit var binding: FragmentHomeReviewBinding

    val mReviewList = ArrayList<ReviewData>()
    lateinit var mReviewAdapter: ReviewAdapter
    var firebase: FirebaseDatabase? = null
    var ref: DatabaseReference? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_review, container, false)

        firebase = FirebaseDatabase.getInstance()
        ref = FirebaseDatabase.getInstance().getReference("review")

        ref?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot!!.exists()) {

                    for (h in snapshot.children) {
                        val reviewData = h.getValue(ReviewData::class.java)
                        mReviewList.add(reviewData!!)
                    }
                    mReviewAdapter.notifyDataSetChanged() //리스트에 파이어베이스 실제 데이터 추가 후 어댑터 바로 새로고침

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        mReviewAdapter = ReviewAdapter(mReviewList, mContext)
        binding.reviewRecyclerView.adapter = mReviewAdapter
        binding.reviewRecyclerView.layoutManager =
            LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.reviewRecyclerView.setHasFixedSize(true) //리싸이클러뷰 내용물에 따라 길이 변경시 자동으로 최적화 세팅해줌.

        //스냅핼퍼 객체화, 리싸이클러뷰에 적용, 뷰페이져처럼 페이지 넘기는 효과
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.reviewRecyclerView)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {


//어댑터에서 만든 아이템클릭 인터페이스 활용 클릭된 아이템 이벤트 처리
        mReviewAdapter.setOnItemClickListener(object : ReviewAdapter.OnItemClickListener{

            override fun onItemClick(v: View, data: ReviewData, pos: Int) {
                Intent(activity,ReviewDetailActivity::class.java ).apply {
                    putExtra("data",data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })
    }

    override fun setValues() {


    }
}