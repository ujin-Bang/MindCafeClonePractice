package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPaymentPhoneBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuPhoneData

class PaymentPhoneActivity : BaseActivity() {

    lateinit var binding: ActivityPaymentPhoneBinding
    lateinit var mData: ExpertConsultingMenuPhoneData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_payment_phone)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearlayoutPaymentPhoneActionBar.visibility = View.VISIBLE

        mData = intent.getSerializableExtra("data") as ExpertConsultingMenuPhoneData
        mTxtPaymentPhoneTitle.text = mData.title

    }
}