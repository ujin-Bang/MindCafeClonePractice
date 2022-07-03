package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityQandAactivityBinding

class QandAActivity : BaseActivity() {

    lateinit var binding: ActivityQandAactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_qand_aactivity)
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}