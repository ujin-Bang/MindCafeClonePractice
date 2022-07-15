package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityExpertDetailBinding

class ExpertDetailActivity : BaseActivity() {

    lateinit var binding: ActivityExpertDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}