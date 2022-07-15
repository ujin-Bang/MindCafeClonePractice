package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityGroupPaymentBinding
import com.start.mindcafeclonepractice.datas.GroupProgramData

class GroupPaymentActivity : BaseActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityGroupPaymentBinding
    lateinit var mData: GroupProgramData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_group_payment)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        spinner()
    }

    override fun setValues() {

        mData = intent.getSerializableExtra("paymentData") as GroupProgramData //받은 데이터 변수에 담기

        //상속받은 액션바 재설정
        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = mData.programTitle

        binding.couponSpinner2.onItemSelectedListener = this

    }

    fun spinner(){

        ArrayAdapter.createFromResource(mContext, R.array.coupon3, android.R.layout.simple_spinner_item)
            .also { adapter ->

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                binding.couponSpinner2.adapter = adapter
            }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(mContext, "${parent?.selectedItem} 선택", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}