package com.start.mindcafeclonepractice


import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityWriteBinding

class WriteActivity : BaseActivity() {

    lateinit var binding: ActivityWriteBinding


override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_write)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {



    }

    override fun setValues() {

    mLinearLayoutMainActionBar.visibility = View.GONE
    mLinearLayoutWriteActionbar.visibility = View.VISIBLE

    }



}