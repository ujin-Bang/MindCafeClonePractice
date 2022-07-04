package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityQandAactivityBinding

class QandAActivity : BaseActivity() {

    lateinit var binding: ActivityQandAactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_qand_aactivity)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        mXBackImg.setOnClickListener {
            finish()
        }

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutQandAActionBar.visibility = View.VISIBLE
    }
}