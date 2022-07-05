package com.start.mindcafeclonepractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityNotice2Binding
import java.math.BigInteger

class NoticeActivity2 : BaseActivity() {

    lateinit var binding: ActivityNotice2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notice2)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        mBtnBack3.setOnClickListener {
            startActivity(Intent(mContext,OriginalNoticeActivity::class.java))
        }
    }

    override fun setValues() {
        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutNoticeActionBar.visibility = View.VISIBLE
    }
}