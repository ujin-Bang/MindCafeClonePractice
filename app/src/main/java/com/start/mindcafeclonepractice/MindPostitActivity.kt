package com.start.mindcafeclonepractice

import android.annotation.SuppressLint
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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

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

    @SuppressLint("SetTextI18n", "CutPasteId")
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

            // editText ?????? ????????? ?????? ?????? ?????????
            inputContent2.addTextChangedListener {
                var userinput = inputContent2.text.toString()
                txtCount.text = userinput.length.toString() + " / 100"
                Log.d("editText",it.toString())
            }


            btnOk.setOnClickListener {
                if (TextUtils.isEmpty(inputContent)) {
                    Toast.makeText(mContext, "???????????? ???????????????.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                val mindPostItData = MindPostItData()//????????????????????? ????????? ?????????????????????

                //?????????????????? ???????????? ?????? => ???: mindPostIt ?????????  ???????????? ???????????????.
                val makeRef = FirebaseDatabase.getInstance().getReference("mindPostIt").push()

                inputContent.toString().also { mindPostItData.content = it }

                val now = Calendar.getInstance()
                val sdf = SimpleDateFormat("yy.MM.dd (E) hh:mm:ss")
                val nowStr = sdf.format(now.time)
                mindPostItData.writeTime = nowStr
                mindPostItData.sympathyCount = 0

                makeRef.setValue(mindPostItData)


                alertDialog.dismiss()//???????????? ????????? ?????????
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
//        binding.mindPostitRecyclerView.layoutManager = LinearLayoutManager(mContext) ????????????, ???????????? ?????????
        binding.mindPostitRecyclerView.setHasFixedSize(true)
//        binding.mindPostitRecyclerView.scrollToPosition(mPostItList.size-1) ????????? ????????? ???????????? ??? ??????????

        // LinearLayout?????? ?????? -> ?????????,?????????????????? :true -> ????????????????????? ??????
        // ?????? ??????????????? ????????? ??????
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