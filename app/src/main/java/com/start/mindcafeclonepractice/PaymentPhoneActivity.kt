package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPaymentPhoneBinding

class PaymentPhoneActivity : BaseActivity() {

    lateinit var binding: ActivityPaymentPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_payment_phone)
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}