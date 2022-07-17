package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPayment22Binding
import com.start.mindcafeclonepractice.datas.ExpertMenuPhoneData

class Payment22Activity : BaseActivity() {

    lateinit var binding: ActivityPayment22Binding
    lateinit var mData: ExpertMenuPhoneData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_payment22)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as ExpertMenuPhoneData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = mData.title
    }
}