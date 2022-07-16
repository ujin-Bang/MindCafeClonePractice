package com.start.mindcafeclonepractice

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPayment2Binding
import com.start.mindcafeclonepractice.datas.ExpertMenuChattData

class Payment2Activity : BaseActivity() {

    lateinit var binding: ActivityPayment2Binding
    lateinit var mData: ExpertMenuChattData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment2)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        couponRegistration()

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("data") as ExpertMenuChattData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE
        mTxtPaymentTitle.text = mData.title

        spinner3()

    }

    @SuppressLint("ResourceType")
    fun spinner3() {
        //스피너 어댑터 세팅
         val spList = arrayListOf(
            "쿠폰을 선택해주세요", "1월 10%할인", "2월 10%할인", "3월 10%할인", "가정의 달10%할인",
            "날씨가 좋아서 10%할인", "추워서 10%할인", "그냥 10%할인"
        )

        val spAdapter = ArrayAdapter(
            mContext,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            spList
        )

        binding.couponSpinner3.adapter = spAdapter

        binding.couponSpinner3.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
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

    fun couponRegistration() {
        binding.couponRegistration2.setOnClickListener {

            val customAlert = LayoutInflater.from(mContext).inflate(R.layout.alert_custom2, null)

            val alert = AlertDialog.Builder(mContext)
                .setView(customAlert)
                .create()

            val btnx = customAlert.findViewById<ImageView>(R.id.btnX)
            val btnCouponCodeCheck = customAlert.findViewById<TextView>(R.id.btnCouponCodeCheck)
            val btnCouponCodeNormal = customAlert.findViewById<TextView>(R.id.btnCouponCodeNormal)
            val btnCouponNameNormal = customAlert.findViewById<TextView>(R.id.btnCouponNameNormal)
            val btnCouponNameCheck = customAlert.findViewById<TextView>(R.id.btnCouponNameCheck)
            val txtText = customAlert.findViewById<TextView>(R.id.txtText)
            val layoutCode = customAlert.findViewById<LinearLayout>(R.id.layoutCode)
            val edtCode = customAlert.findViewById<EditText>(R.id.edtCode)
            val layoutName = customAlert.findViewById<LinearLayout>(R.id.layoutName)
            val edtName = customAlert.findViewById<EditText>(R.id.edtName)
            val btnCouponIssued = customAlert.findViewById<Button>(R.id.btnCouponIssued)


            btnx.setOnClickListener {
                alert.dismiss()
            }

            btnCouponCodeNormal.setOnClickListener {
                btnCouponCodeNormal.visibility = View.GONE
                btnCouponCodeCheck.visibility = View.VISIBLE
                btnCouponNameCheck.visibility = View.GONE
                btnCouponNameNormal.visibility = View.VISIBLE
                txtText.text = "쿠폰 코드를 입력해주세요."
                layoutCode.visibility = View.VISIBLE
                layoutName.visibility = View.GONE

            }

            btnCouponNameNormal.setOnClickListener {
                btnCouponNameNormal.visibility = View.GONE
                btnCouponNameCheck.visibility = View.VISIBLE
                btnCouponCodeCheck.visibility = View.GONE
                btnCouponCodeNormal.visibility = View.VISIBLE
                txtText.text = "쿠폰 이름을 입력해주세요"
                layoutName.visibility = View.VISIBLE
                layoutCode.visibility = View.GONE
            }

            btnCouponIssued.setOnClickListener {
                if (btnCouponCodeCheck.visibility == View.VISIBLE) {

                    if (edtCode.length() < 19) {
                        Toast.makeText(mContext, "16자리 숫자 코드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }


                }
                else {
                    if (edtName.length() == 0){
                        Toast.makeText(mContext, "쿠폰 이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

            }

        }

        alert.show()

    }
}
}