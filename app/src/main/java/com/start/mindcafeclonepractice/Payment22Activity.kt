package com.start.mindcafeclonepractice

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

class Payment22Activity : BaseActivity() {

    lateinit var binding: ActivityPayment22Binding
    lateinit var mData: ExpertMenuPhoneData

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
    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as ExpertMenuPhoneData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = mData.title
        binding.txtMenuDetailContent.text = mData.detailContent
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
                }

            }
            else{
                if (edtName.length() == 0){
                    Toast.makeText(mContext, "쿠폰 이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    edtName.requestFocus()//edtiText에 포커스 위치시키기
                }
            }
        }


        alert.show()
    }
}