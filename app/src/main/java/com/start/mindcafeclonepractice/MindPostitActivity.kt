package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.FirebaseDatabase
import com.start.mindcafeclonepractice.databinding.ActivityMindPostitBinding
import com.start.mindcafeclonepractice.datas.MindPostItData

class MindPostitActivity : BaseActivity() {

    lateinit var binding: ActivityMindPostitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mind_postit)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnPostItWright.setOnClickListener {

        val dialogCustom = LayoutInflater.from(mContext).inflate(R.layout.alert_dialog_custom,null)
        val alertDialog = AlertDialog.Builder(mContext)
            .setView(dialogCustom)
            .create()

        val inputContent = dialogCustom.findViewById<EditText>(R.id.edtContent).text
        val btnOk = dialogCustom.findViewById<TextView>(R.id.btnOk)

            btnOk.setOnClickListener {
                if(TextUtils.isEmpty(inputContent)){
                    Toast.makeText(mContext, "메시지를 입력하세요.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                val mindPostItData = MindPostItData()//데이타베이스에 저장할 데이타객체생성

                //파이어베이스 참조객체 생성 =>mindPostIt 만들어서 푸시하겠다.
                val makeRef = FirebaseDatabase.getInstance().getReference("mindPostIt").push()

                mindPostItData.content = inputContent.toString()
                
                makeRef.setValue(mindPostItData)


                alertDialog.dismiss()//완료버튼 누르면 창닫힘
            }
            alertDialog.show()

        }

    }

    override fun setValues() {
        mLinearLayoutMainActionBar.visibility = View.GONE
        mlinearLayoutMindPostItActionBar.visibility = View.VISIBLE
    }
}