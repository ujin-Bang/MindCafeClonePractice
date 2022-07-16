package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityExpertConsultingMenuChattPhoneBinding
import com.start.mindcafeclonepractice.datas.CoachData

class ExpertConsultingMenuChattPhoneActivity : BaseActivity() {

    lateinit var binding: ActivityExpertConsultingMenuChattPhoneBinding
    lateinit var mData: CoachData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expert_consulting_menu_chatt_phone)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as CoachData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = "                         ${mData.name}"

    }
}