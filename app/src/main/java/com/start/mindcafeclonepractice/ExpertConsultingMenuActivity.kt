package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityExpertConsultingMenuactivityBinding
import com.start.mindcafeclonepractice.databinding.ActivitySelectExpertConsultingMenuBinding

class ExpertConsultingMenuActivity : BaseActivity() {

    lateinit var binding: ActivityExpertConsultingMenuactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_consulting_menuactivity)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}

