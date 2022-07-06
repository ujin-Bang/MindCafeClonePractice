package com.start.mindcafeclonepractice

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.start.mindcafeclonepractice.adapters.MindPostItAdapter
import com.start.mindcafeclonepractice.databinding.ActivityMindPostitBinding
import com.start.mindcafeclonepractice.datas.MindPostItData

class MindPostitActivity : BaseActivity() {

    lateinit var binding: ActivityMindPostitBinding
    val mPostItList = ArrayList<MindPostItData>()

    lateinit var mPostItAdapter: MindPostItAdapter
    var ref: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mind_postit)

        setupEvents()
        setValues()


    }

    override fun setupEvents() {

        binding.btnPostItWright.setOnClickListener {

            val dialogCustom =
                LayoutInflater.from(mContext).inflate(R.layout.alert_dialog_custom, null)
            val alertDialog = AlertDialog.Builder(mContext)
                .setView(dialogCustom)
                .create()



            val inputContent = dialogCustom.findViewById<EditText>(R.id.edtContent).text
            val inputContent2 = dialogCustom.findViewById<EditText>(R.id.edtContent)
            val btnOk = dialogCustom.findViewById<TextView>(R.id.btnOk)
            var txtCount = dialogCustom.findViewById<TextView>(R.id.txtCount)

            // editText 내용 길이에 따라 숫자 바꾸기
            inputContent2.addTextChangedListener {
                var userinput = inputContent2.text.toString()
                txtCount.text = userinput.length.toString() + " / 100"
                Log.d("editText",it.toString())
            }


            btnOk.setOnClickListener {
                if (TextUtils.isEmpty(inputContent)) {
                    Toast.makeText(mContext, "메시지를 입력하세요.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                val mindPostItData = MindPostItData()//데이타베이스에 저장할 데이타객체생성

                //파이어베이스 참조객체 생성 => 키: mindPostIt 저장소  만들어서 푸시하겠다.
                val makeRef = FirebaseDatabase.getInstance().getReference("mindPostIt").push()

                inputContent.toString().also { mindPostItData.content = it }

                makeRef.setValue(mindPostItData)


                alertDialog.dismiss()//완료버튼 누르면 창닫힘
            }
            alertDialog.show()

        }

    }

    override fun setValues() {
        mLinearLayoutMainActionBar.visibility = View.GONE
        mlinearLayoutMindPostItActionBar.visibility = View.VISIBLE

        getPostItDataFromFirebase()


    }


    fun getPostItDataFromFirebase() {


        ref = FirebaseDatabase.getInstance().getReference("mindPostIt")
        ref?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {

                    mPostItList.clear()
                    for (h in snapshot.children) {
                        val data = h.getValue(MindPostItData::class.java)


                        mPostItList.add(data!!)
                    }


                    mPostItAdapter.notifyDataSetChanged()

                }
            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(mContext, error.message, Toast.LENGTH_SHORT).show()
            }

        })
        mPostItAdapter = MindPostItAdapter(mContext, mPostItList)
        binding.mindPostitRecyclerView.adapter = mPostItAdapter
//        binding.mindPostitRecyclerView.layoutManager = LinearLayoutManager(mContext) 세로목록, 차례대로 나오게
        binding.mindPostitRecyclerView.setHasFixedSize(true)
//        binding.mindPostitRecyclerView.scrollToPosition(mPostItList.size-1) 마지막 포지션 보여주기 왜 안되지?

        // LinearLayout객체 생성 -> 리버스,스택프롬앤드 :true -> 리싸이클러뷰에 대입
        // 가장 최근글부터 보이는 효과
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        binding.mindPostitRecyclerView.layoutManager = linearLayoutManager

    }


    override fun onResume() {
        super.onResume()
        getPostItDataFromFirebase()
    }

}