package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityMindPostitBinding

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
                alertDialog.dismiss()
                Log.d("입력값","content: ${inputContent}")
            }
            alertDialog.show()

        }

    }

    override fun setValues() {
        mLinearLayoutMainActionBar.visibility = View.GONE
        mlinearLayoutMindPostItActionBar.visibility = View.VISIBLE
    }
}