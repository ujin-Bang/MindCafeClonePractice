package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ReviewAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeReviewBinding
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

                if (snapshot!!.exists()){

                    for (h in snapshot.children){
                        val reviewData = h.getValue(ReviewData::class.java)
                        mReviewList.add(reviewData!!)
                    }
                    mReviewAdapter.notifyDataSetChanged()

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        mReviewAdapter = ReviewAdapter(mReviewList, mContext)
        binding.reviewRecyclerView.adapter = mReviewAdapter
        binding.reviewRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false)
        binding.reviewRecyclerView.setHasFixedSize(true)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}