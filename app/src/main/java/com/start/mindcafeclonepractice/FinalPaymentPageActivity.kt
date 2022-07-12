package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityFinalPaymentPageBinding

class FinalPaymentPageActivity : BaseActivity() {

    lateinit var binding: ActivityFinalPaymentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_final_payment_page)
    }

    override fun setupEvents() {

    }

    override fun setValues() {
    }
}