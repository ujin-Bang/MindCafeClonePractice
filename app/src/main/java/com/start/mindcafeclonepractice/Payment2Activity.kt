package com.start.mindcafeclonepractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPayment2Binding
import com.start.mindcafeclonepractice.datas.ExpertMenuChattData

class Payment2Activity : BaseActivity() {

    lateinit var binding: ActivityPayment2Binding
    lateinit var mData: ExpertMenuChattData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_payment2)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as ExpertMenuChattData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE
        mTxtPaymentTitle.text = mData.title

        spinner3()

    }

    @SuppressLint("ResourceType")
    fun spinner3(){
         //스피너 어댑터 세팅
        val spList = arrayListOf("쿠폰을 선택해주세요","1월 10%할인","2월 10%할인","3월 10%할인","가정의 달10%할인",
                                 "날씨가 좋아서 10%할인","추워서 10%할인","그냥 10%할인")

        val spAdapter = ArrayAdapter(mContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,spList)

        binding.couponSpinner3.adapter = spAdapter

        binding.couponSpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("선택된 스피너 항목", parent?.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }



    }
}