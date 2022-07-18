package com.start.mindcafeclonepractice

import android.annotation.SuppressLint
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.adapters.ExpertMenuPhoneRecylerAdapter
import com.start.mindcafeclonepractice.databinding.ActivityPayment22Binding
import com.start.mindcafeclonepractice.datas.ExpertMenuPhoneData
import java.text.DecimalFormat

class Payment22Activity : BaseActivity() {

    lateinit var binding: ActivityPayment22Binding
    lateinit var mData: ExpertMenuPhoneData

    val dec = DecimalFormat("#,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment22)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        spinner()

        binding.btnCouponRegistration.setOnClickListener {

            couponRegistration()

        }

        paymentMethod()

        binding.btnOk.setOnClickListener {
            startActivity(Intent(mContext, FinalPaymentActivity::class.java))
        }
    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as ExpertMenuPhoneData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = mData.title
        binding.txtMenuDetailContent.text = mData.detailContent

        paymentCalculator()
    }

    //스피너 만들기
    fun spinner() {
        val spSpinner = arrayListOf<String>(
            "쿠폰을 선택해주세요.",
            "오늘만 10%할인",
            "내일만 10%할인",
            "비오면 10%할인",
            "눈오면 10%할인",
            "다이어트 성공시10%할인",
            "라면먹고 오면10%할인",
            "무조건 10%할인"
        )

        val arrAdapter = ArrayAdapter<String>(
            mContext,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            spSpinner
        )
        binding.spCoupon.adapter = arrAdapter

        binding.spCoupon.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val normalPri = mData.normalPrice
                val discount005 = normalPri?.times(0.05)
                val discount01 = normalPri!! * 0.1
                val couponDiscount = normalPri * 0.1

                binding.normalPrice.text = "${dec.format(normalPri)}원"

                if (parent != null) {
                    if (parent.selectedItemPosition != 0){

                        if (normalPri < 100000){

                            binding.couponDiscountPrice.text = "-${dec.format(couponDiscount)}원"
                            binding.resultPrice.text = "${dec.format(normalPri - couponDiscount)}원"
                        }

                        else if (normalPri < 300000) {

                            binding.couponDiscountPrice.text = "-${dec.format(couponDiscount)}원"
                            binding.resultPrice.text = "${dec.format(normalPri - discount005!! - couponDiscount)}원"
                        }

                        else{

                            binding.couponDiscountPrice.text = "-${dec.format(couponDiscount)}원"
                            binding.resultPrice.text = "${dec.format(normalPri - discount01 - couponDiscount)}원"

                        }
                    }

                    else{

                        if (normalPri < 100000){
                            binding.couponDiscountPrice.text = "${parent.selectedItem}"
                            binding.resultPrice.text = "${dec.format(normalPri)}원"
                        }

                        else if (normalPri < 300000){

                            binding.couponDiscountPrice.text = "${parent.selectedItem}"
                            binding.resultPrice.text = "${dec.format(normalPri - discount005!!)}원"
                        }

                        else {

                            binding.couponDiscountPrice.text = "${parent.selectedItem}"
                            binding.resultPrice.text = "${dec.format(normalPri - discount01)}"
                        }
                    }

                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    //쿠폰등록하기
    fun couponRegistration() {


        val customAlert = LayoutInflater.from(mContext)
            .inflate(R.layout.coupon_registration_custom_alert_dialog, null)

        val alert = AlertDialog.Builder(mContext)
            .setView(customAlert)
            .create()

        val btnX = customAlert.findViewById<ImageView>(R.id.btnX)
        val btnCouponCodeChecked = customAlert.findViewById<TextView>(R.id.btnCouponCodeChecked)
        val btnCouponCode = customAlert.findViewById<TextView>(R.id.btnCouponCode)
        val btnCouponName = customAlert.findViewById<TextView>(R.id.btnCouponName)
        val btnCouponNameChecked = customAlert.findViewById<TextView>(R.id.btnCouponNameChecked)
        val txtPhrase = customAlert.findViewById<TextView>(R.id.txtPhrase)
        val edtLayoutCode = customAlert.findViewById<LinearLayout>(R.id.edtLayoutCode)
        val edtCode = customAlert.findViewById<EditText>(R.id.edtCode)
        val edtName = customAlert.findViewById<EditText>(R.id.edtName)
        val edtLayoutName = customAlert.findViewById<LinearLayout>(R.id.edtLayoutName)
        val btnCouponIssued = customAlert.findViewById<Button>(R.id.btnCouponIssued)
        
        btnX.setOnClickListener { 
            alert.dismiss()
        }
        
        btnCouponCode.setOnClickListener { 
            btnCouponCode.visibility = View.GONE
            btnCouponCodeChecked.visibility = View.VISIBLE
            btnCouponName.visibility = View.VISIBLE
            btnCouponNameChecked.visibility = View.GONE
            txtPhrase.text = "쿠폰 코드를 입력해주세요."
            edtLayoutCode.visibility = View.VISIBLE
            edtLayoutName.visibility = View.GONE
        }
        
        btnCouponName.setOnClickListener { 
            btnCouponName.visibility = View.GONE
            btnCouponNameChecked.visibility = View.VISIBLE
            btnCouponCode.visibility = View.VISIBLE
            btnCouponCodeChecked.visibility = View.GONE
            txtPhrase.text = "쿠폰 이름을 입력해주세요."
            edtLayoutCode.visibility = View.GONE
            edtLayoutName.visibility = View.VISIBLE
        }
        
        btnCouponIssued.setOnClickListener { 
            if (btnCouponCodeChecked.visibility == View.VISIBLE){

                if (edtCode.length() <16){

                    Toast.makeText(mContext, "16자리 쿠폰코드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    edtCode.requestFocus()//editText에 포커스 위치시키기
                    return@setOnClickListener
                }

            }
            else{
                if (edtName.length() == 0){
                    Toast.makeText(mContext, "쿠폰 이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    edtName.requestFocus()//edtiText에 포커스 위치시키기
                    return@setOnClickListener
                }
            }
        }


        alert.show()
    }

    //최종 결제금액 계산
    fun paymentCalculator(){

        val normalPri = mData.normalPrice
        val normalPriceStr = dec.format(normalPri)
        val discountPri005 = normalPri?.times(0.05)
        val discountPri01 = normalPri?.times(0.1)

        binding.normalPrice.text = "${normalPriceStr}원"

        if (normalPri != null) {

            if (normalPri < 100000) {
                binding.layoutDiscount.visibility = View.GONE
                binding.resultPrice.text = "${dec.format(normalPri)}원"
            }
            else if (normalPri < 300000) {
                binding.discountPrice.text = "-${dec.format(discountPri005)}원"
                binding.resultPrice.text = "${dec.format(normalPri - discountPri005!!)}원 "
            }
            else {
                binding.discountPrice.text = "-${dec.format(discountPri01)}원"
                binding.resultPrice.text = "${dec.format(normalPri - discountPri01!!)}원"

            }
        }
        binding.discountPrice
    }

    //결제 수단 선택
    fun paymentMethod(){

        binding.btnCouponCode.setOnClickListener {
            binding.btnCouponCode.visibility = View.GONE
            binding.btnCouponCodeChecked.visibility = View.VISIBLE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE
        }

        binding.btnPhonePayment.setOnClickListener {
            binding.btnPhonePayment.visibility = View.GONE
            binding.btnPhonePaymentChecked.visibility = View.VISIBLE
            binding.btnCouponCode.visibility = View.VISIBLE
            binding.btnCouponCodeChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE
        }

        binding.btnRealtimeAccountTransfer.setOnClickListener {
            binding.btnRealtimeAccountTransfer.visibility = View.GONE
            binding.btnRealtimeAccountTransferChecked.visibility = View.VISIBLE
            binding.btnCouponCode.visibility = View.VISIBLE
            binding.btnCouponCodeChecked.visibility = View.GONE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
        }
    }


}