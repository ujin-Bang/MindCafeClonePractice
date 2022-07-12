package com.start.mindcafeclonepractice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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

        spinner()
    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearlayoutPaymentPhoneActionBar.visibility = View.VISIBLE

        mData = intent.getSerializableExtra("data") as ExpertConsultingMenuPhoneData
        mTxtPaymentPhoneTitle.text = mData.title

    }

    fun spinner(){
        val spinnerList = arrayListOf("쿠폰을 선택해주세요.","10% 매달 첫째주 할인","20% 방학할인","10% 생일맞이 할인","30% 개근상 할인","10% 가족할인","10% 친구추천 할인")
        val spAdapter = ArrayAdapter<String>(mContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,spinnerList)
        binding.phoneCouponSpinner.adapter = spAdapter


        binding.phoneCouponSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

               if (parent != null){

                   Log.d("스피너 아이템 선택: ", "${parent.selectedItem}을 선택했습니다..")
//                    Toast.makeText(mContext, "${parent.selectedItem} ", Toast.LENGTH_SHORT).show()
              }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}