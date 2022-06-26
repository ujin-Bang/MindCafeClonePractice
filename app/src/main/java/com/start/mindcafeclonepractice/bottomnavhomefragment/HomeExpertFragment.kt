package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.CoachAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentExpertBinding
import com.start.mindcafeclonepractice.datas.CoachData


class HomeExpertFragment: BaseFragment() {

    lateinit var binding: FragmentExpertBinding
    val mExpertProfileList = ArrayList<CoachData>()
    var firebase : FirebaseDatabase? = null
    var ref : DatabaseReference? = null
    lateinit var mExpertProfileAdapter: CoachAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expert, container, false)

        firebase = FirebaseDatabase.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("coachProfile")

        ref?.addValueEventListener( object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot!!.exists()){
                    for (h in snapshot.children){
                        val coachPforile =  h.getValue(CoachData::class.java)

                        mExpertProfileList.add(coachPforile!!)
                    }
                    mExpertProfileAdapter = CoachAdapter(mContext,mExpertProfileList)
                    binding.expertRecyclerView.adapter = mExpertProfileAdapter
                    binding.expertRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                    binding.expertRecyclerView.setHasFixedSize(true)
                    mExpertProfileAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.d("파이어베이스에러메시지",error.message)
            }

        } )


        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.expertRecyclerView)


//        val snapHelper: LinearSnapHelper = object : LinearSnapHelper() {
//            override fun findTargetSnapPosition(
//                layoutManager: RecyclerView.LayoutManager,
//                velocityX: Int,
//                velocityY: Int
//            ): Int {
//                val centerView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
//                val position = layoutManager.getPosition(centerView)
//                var targetPosition = -1
//                if (layoutManager.canScrollHorizontally()) {
//                    targetPosition = if (velocityX < 0) {
//                        position - 1
//                    } else {
//                        position + 1
//                    }
//                }
//                if (layoutManager.canScrollVertically()) {
//                    targetPosition = if (velocityY < 0) {
//                        position - 1
//                    } else {
//                        position + 1
//                    }
//                }
//                val firstItem = 0
//                val lastItem = layoutManager.itemCount - 1
//                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem))
//                return targetPosition
//            }
//        }
//        snapHelper.attachToRecyclerView(binding.expertRecyclerView)
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