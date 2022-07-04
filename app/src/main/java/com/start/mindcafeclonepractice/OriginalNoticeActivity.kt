package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityOriginalNoticeBinding

class OriginalNoticeActivity : BaseActivity() {

    lateinit var binding: ActivityOriginalNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_original_notice)
        setupEvents()
        setValues()
    }




    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutOriginNoticeActionBar.visibility = View.VISIBLE
        mLinearLayoutMainActionBar.visibility = View.GONE


    }
}