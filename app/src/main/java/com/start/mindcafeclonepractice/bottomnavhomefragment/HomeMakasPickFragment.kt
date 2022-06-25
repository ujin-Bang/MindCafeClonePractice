package com.start.mindcafeclonepractice.bottomnavhomefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.adapters.WriterAdapter
import com.start.mindcafeclonepractice.bottomnavfragments.BaseFragment
import com.start.mindcafeclonepractice.databinding.FragmentHomeMakasPickBinding
import com.start.mindcafeclonepractice.datas.WriterData
import java.util.Collections.max
import kotlin.math.max

class HomeMakasPickFragment : BaseFragment() {

    lateinit var binding: FragmentHomeMakasPickBinding
    val mWriterList = ArrayList<WriterData>()
    var firebase: FirebaseDatabase? = null
    var ref: DatabaseReference? = null
    lateinit var mWriterAdapter: WriterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_makas_pick, container, false)


        firebase = FirebaseDatabase.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("write")

        ref?.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot!!.exists()){
                    for (h in snapshot.children){
                        val witer = h.getValue(WriterData::class.java)
                        mWriterList.add(witer!!)

                    }
                    mWriterAdapter = WriterAdapter(mContext, mWriterList)
                    binding.makasRecyclerView.adapter = mWriterAdapter
                    binding.makasRecyclerView.setHasFixedSize(true)
                    binding.makasRecyclerView.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL, false)

                }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.d("파이어베이스 응답에러 메시지",error.toString())
            }


        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.txtMacasPick.setOnClickListener {

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("마카's PICK이란?")
            alert.setMessage("마인드카페 커뮤니티 내 전문답변을 \n받은 사연들 " +
                    "중 선택된 사연들입니다.\n \n전문답변 \n고민요약, 고민과 관련된 원인 분석, " +
                    "\n고민에 대한 해결방안과 대처 방안" +
                    "을 더 도움 \n받을 수 있는 측면에 대한전문가들의 " +
                    "답변을 \n받을 수 있습니다.")
            alert.setPositiveButton("확인", null)
            alert.show()

        }


        binding.btnRight.setOnClickListener {


        }
    }

    override fun setValues() {

        binding.makasRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    val firstPos = (binding.makasRecyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                    val secondPos = (binding.makasRecyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    val selectedPos = max(firstPos,secondPos)
                    if(selectedPos!=-1){
                        val viewItem = (binding.makasRecyclerView.layoutManager as LinearLayoutManager).findViewByPosition(selectedPos)
                        viewItem?.run{
                            val itemMargin = (binding.makasRecyclerView.measuredWidth-viewItem.measuredWidth)/2
                            binding.makasRecyclerView.smoothScrollBy( this.x.toInt()-itemMargin , 0)
                        }

                    }
                }
            }
        })
    }

}