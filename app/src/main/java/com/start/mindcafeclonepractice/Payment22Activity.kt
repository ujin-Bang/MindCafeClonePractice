package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.adapters.ExpertMenuPhoneRecylerAdapter
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

        spinner()

        binding.btnCouponRegistration.setOnClickListener {
            
            couponRegistration()

        }
    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as ExpertMenuPhoneData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = mData.title
        binding.txtMenuDetailContent.text = mData.detailContent
    }

    //스피너 만들기
    fun spinner(){
        val spSpinner = arrayListOf<String>("쿠폰을 선택해주세요.","오늘만 10%할인","내일만 10%할인","비오면 10%할인"
                                            ,"눈오면 10%할인","다이어트 성공시10%할인","라면먹고 오면10%할인","무조건 10%할인")

        val arrAdapter = ArrayAdapter<String>(mContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spSpinner)
        binding.spCoupon.adapter = arrAdapter

        binding.spCoupon.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    //쿠폰등록하기
    fun couponRegistration(){


        val customAlert = LayoutInflater.from(mContext).inflate(R.layout.coupon_registration_custom_alert_dialog,null)

        val alert = AlertDialog.Builder(mContext)
            .setView(customAlert)
            .create()


            alert.show()
    }
}