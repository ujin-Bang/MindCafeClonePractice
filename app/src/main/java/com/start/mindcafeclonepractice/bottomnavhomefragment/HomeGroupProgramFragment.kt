package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.GroupDetailActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.ExpertConsultingMenuPhoneRecyclerAdapter
import com.start.mindcafeclonepractice.adapters.GropuProgramAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeGroupProgramBinding
import com.start.mindcafeclonepractice.datas.GroupProgramData

class HomeGroupProgramFragment: BaseFragment() {

    lateinit var binding: FragmentHomeGroupProgramBinding
    val mGroupProgramList = ArrayList<GroupProgramData>()
    lateinit var mGroupProgramAdapter: GropuProgramAdapter
    var firebase: FirebaseDatabase? = null
    var ref: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_group_program, container, false)

       firebase = FirebaseDatabase.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("groupProgram")

        ref?.addValueEventListener( object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot!!.exists()){
                    for( h in snapshot.children){
                        val groupProgram = h.getValue(GroupProgramData::class.java)

                        mGroupProgramList.add(groupProgram!!)
                    }

                    mGroupProgramAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(mContext, error.message, Toast.LENGTH_SHORT).show()
            }

        })
        mGroupProgramAdapter = GropuProgramAdapter(mContext, mGroupProgramList)
        binding.groupProgramRecyclerView.adapter = mGroupProgramAdapter
        binding.groupProgramRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        binding.groupProgramRecyclerView.setHasFixedSize(true)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.groupProgramRecyclerView)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnGroupProgramInfo.setOnClickListener {

            val alert = AlertDialog.Builder(mContext)
                alert.setTitle("?????????????????????????")
                alert.setMessage("?????? ???????????? ?????? ????????? ?????? ??? ????????? ??????(4~10???)?????? ???????????? ?????????????????????.\n" +
                        "????????????????????? ????????? ?????? ????????? ????????? ???????????? ????????? ?????? ??????????????? ???????????????." +
                        "\n\n1.?????? ?????????\n???????????? ???????????? ??????????????? ???????????? ?????? ?????? ?????????\n\n2. ????????????" +
                        "\n????????? ???????????? ?????? ????????? ???????????? ?????? ???????????????")
                alert.setPositiveButton("??????",null)
                alert.show()
        }

        groupProgramRecyclerViewItemClicked()
    }

    override fun setValues() {

    }


    fun groupProgramRecyclerViewItemClicked(){

        mGroupProgramAdapter.setOnItemClickListener(object : GropuProgramAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: GroupProgramData, position: Int) {
                Intent(mContext, GroupDetailActivity::class.java).apply {

                    putExtra("data",data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })

    }
}