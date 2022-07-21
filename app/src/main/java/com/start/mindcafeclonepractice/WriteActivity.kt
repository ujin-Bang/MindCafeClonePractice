package com.start.mindcafeclonepractice


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.adapters.CommunityRecyclerAdatpter
import com.start.mindcafeclonepractice.databinding.ActivityWriteBinding
import com.start.mindcafeclonepractice.datas.CommunityTitleData

class WriteActivity : BaseActivity() {

    lateinit var binding: ActivityWriteBinding
    val mList = ArrayList<CommunityTitleData>()
    lateinit var mAdapter: CommunityRecyclerAdatpter
    var ref: DatabaseReference? = null


    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

        communityTitleRecyclerViewItemClick()

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutWriteActionbar.visibility = View.VISIBLE

        getCommunityTitleDataFromFirebase()




    }

    //파이어베이스에서 커뮤니티 제목 데이터 받아와서 리스트에 추가 + 어댑터 연결까지
    fun getCommunityTitleDataFromFirebase() {

        ref = FirebaseDatabase.getInstance().getReference("community")
        ref?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (h in snapshot.children) {
                        val myData = h.getValue(CommunityTitleData::class.java)
                        if (myData != null) {
                            mList.add(myData)
                        }
                    }
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        mAdapter = CommunityRecyclerAdatpter(mContext, mList)
        binding.cummunityTitleRecyclerView.adapter = mAdapter
        binding.cummunityTitleRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.cummunityTitleRecyclerView.setHasFixedSize(true)
    }

    //리싸이클러뷰 아이템 클릭이벤트
    fun communityTitleRecyclerViewItemClick() {

        auth = FirebaseAuth.getInstance()
        val loginFirebaseUID = auth.currentUser?.uid

        mAdapter.setOnItemClickListener(object : CommunityRecyclerAdatpter.OnItemClickListener{
            override fun onClick(v: View, data: CommunityTitleData, position: Int) {
                Intent(mContext,WritingActivity::class.java).apply {
                    putExtra("data", data)
                    putExtra("auth",loginFirebaseUID)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })
    }

}