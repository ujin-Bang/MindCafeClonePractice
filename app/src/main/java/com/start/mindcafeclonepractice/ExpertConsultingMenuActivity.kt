package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityExpertConsultingMenuactivityBinding
import com.start.mindcafeclonepractice.databinding.ActivitySelectExpertConsultingMenuBinding
import com.start.mindcafeclonepractice.datas.ReviewData

class ExpertConsultingMenuActivity : BaseActivity() {

    lateinit var binding: ActivityExpertConsultingMenuactivityBinding
    lateinit var mData: ReviewData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_consulting_menuactivity)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutNewExpertSelectedConsultingMenu.visibility = View.VISIBLE
        mData = intent.getSerializableExtra("data") as ReviewData

        mSelectedExpertName.text = mData.coachName

    }
}

