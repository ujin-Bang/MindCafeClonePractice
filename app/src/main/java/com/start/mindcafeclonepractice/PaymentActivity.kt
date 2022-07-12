package com.start.mindcafeclonepractice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPaymentBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuChattData
import java.text.DecimalFormat
import java.util.*
import java.util.stream.IntStream

class PaymentActivity : BaseActivity() {

    lateinit var binding: ActivityPaymentBinding
    lateinit var mData: ExpertConsultingMenuChattData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment)
        setupEvents()
        setValues()

    }

    @SuppressLint("ResourceAsColor")
    override fun setupEvents() {

        spinnerClicked()

        binding.btnCouponRegistration.setOnClickListener {

            val customDialog = LayoutInflater.from(mContext)
                .inflate(R.layout.coupon_registration_custom_alert, null)
            val alert = AlertDialog.Builder(mContext)
                .setView(customDialog)
                .create()

            val btnX = customDialog.findViewById<ImageView>(R.id.btnCouponRegistrationX)
            val btnCouponCode = customDialog.findViewById<TextView>(R.id.txtCouponCode)
            val btnCouponCode2 = customDialog.findViewById<TextView>(R.id.txtCouponCode2)
            val btnCouponName = customDialog.findViewById<TextView>(R.id.txtCouponName)
            val btnCouponName2 = customDialog.findViewById<TextView>(R.id.txtCouponName2)
            val edtCouponCode = customDialog.findViewById<EditText>(R.id.edtCouponCode)
            val edtCouponName = customDialog.findViewById<EditText>(R.id.edtCouponCode2)
            val btnCouponIssued = customDialog.findViewById<TextView>(R.id.btnCouponIssued)
            val txtMessage = customDialog.findViewById<TextView>(R.id.txtMessage)





            btnX.setOnClickListener {
                alert.dismiss()// X버튼 누르면 창닫힘
            }

            btnCouponCode.setOnClickListener {

                btnCouponCode.visibility = View.VISIBLE
                btnCouponCode2.visibility = View.GONE
                btnCouponName.visibility = View.VISIBLE
                btnCouponName2.visibility = View.GONE
                edtCouponCode.visibility = View.VISIBLE
                edtCouponName.visibility = View.GONE
                txtMessage.text = "쿠폰 코드를 입력해주세요."

            }

            btnCouponCode2.setOnClickListener {

                btnCouponCode.visibility = View.VISIBLE
                btnCouponCode2.visibility = View.GONE
                btnCouponName.visibility = View.VISIBLE
                btnCouponName2.visibility = View.GONE
                edtCouponCode.visibility = View.VISIBLE
                edtCouponName.visibility = View.GONE
                txtMessage.text = "쿠폰 코드를 입력해주세요."


            }

            btnCouponName.setOnClickListener {

                btnCouponName.visibility = View.GONE
                btnCouponName2.visibility = View.VISIBLE
                btnCouponCode.visibility = View.GONE
                btnCouponCode2.visibility = View.VISIBLE
                edtCouponCode.visibility = View.GONE
                edtCouponName.visibility = View.VISIBLE
                txtMessage.text = "쿠폰 이름을 입력해주세요."


            }

            btnCouponName2.setOnClickListener {

                btnCouponName.visibility = View.GONE
                btnCouponName2.visibility = View.VISIBLE
                btnCouponCode.visibility = View.GONE
                btnCouponCode2.visibility = View.VISIBLE
                edtCouponCode.visibility = View.GONE
                edtCouponName.visibility = View.VISIBLE
                txtMessage.text = "쿠폰 이름을 입력해주세요."

            }

            btnCouponIssued.setOnClickListener {
                if (btnCouponCode.visibility == View.VISIBLE) {

                    if (edtCouponCode.text.isEmpty()) {

                        Toast.makeText(mContext, "쿠폰 코드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                } else {
                    Toast.makeText(mContext, "쿠폰 이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            alert.show()

        }

        binding.btnOk.setOnClickListener {

            startActivity(Intent(mContext,FinalPaymentPageActivity::class.java))
        }


    }

    @SuppressLint("SetTextI18n")
    override fun setValues() {
        mData = intent.getSerializableExtra("data") as ExpertConsultingMenuChattData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE
        mTxtPaymentTitle.text = mData.title


        payment()

        paymentMethod()

    }


    fun spinnerClicked() {

        //어댑터 활용 spinner에 들어갈 아이템리스트 목록 만들고 스피너에 연결 -스피너 커스텀하기
        val customList =
            arrayListOf("쿠폰선택", "10% 할인", "20% 할인", "여름 방학 할인", "주중 할인", "공휴일 할인", "1년 할인")

        //support_simple_spinner_dropdouw_item => 기본스피너 모양 안드로이드에서 제공
        val adapter = ArrayAdapter<String>(
            mContext,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            customList
        )
        binding.couponSpinner.adapter = adapter

        binding.couponSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    Log.d("스피너아이템선택", "위치 : ${position}번째")

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
    }

    fun payment(){

        val dec = DecimalFormat("#,###") //DecimalFomat객체화 : 3자리마다 콤마 기능
        val fixedPrice = mData.fixedPrice // 받아온 데이타가격 데이터 변수에 담기

        val fixedPriceStr = dec.format(fixedPrice) // 받아온 데이타 3자리마다 콤마찍기
        binding.txtFixedPrice.text = "${fixedPriceStr}원" // 실제 데이터 정가 텍스트뷰의 텍스트에 표현

        //널 체크 후 => 상담금액에 따른 할인률 적용하기
        if (fixedPrice != null) {

            //if문 사용 fixedPrice 가 100000~199999 이라면
            if (fixedPrice in 100000..199999) {

                val discountPrice = fixedPrice * 0.05
                binding.txtDiscount.text = "-${dec.format(discountPrice)}원"

                val totalPrice = fixedPrice - discountPrice
                binding.txtTotalPrice.text = "${dec.format(totalPrice)}원"
            }

            //fixedPrice 값이 0~ 99999 이라면
            if (fixedPrice in 0..99999) {
                binding.txtDiscount.text = "0원"

                binding.txtTotalPrice.text = "${fixedPriceStr}원"
            }

            //fixedPrice값이 200000~2000000 이라면
            if (fixedPrice in 200000..2000000) {
                val discountPrice = fixedPrice * 0.1
                binding.txtDiscount.text = "-${dec.format(discountPrice)}원"

                val totalPrice = fixedPrice - discountPrice
                binding.txtTotalPrice.text = "${dec.format(totalPrice)}원"
            }
        }
    }

    fun paymentMethod(){

        binding.btnCreditCardChecked.setOnClickListener {
            binding.btnCreditCard.visibility = View.GONE
            binding.btnCreditCardChecked.visibility = View.VISIBLE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE
        }

        binding.btnCreditCard.setOnClickListener {
            binding.btnCreditCard.visibility = View.GONE
            binding.btnCreditCardChecked.visibility = View.VISIBLE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE

        }

        binding.btnPhonePayment.setOnClickListener {
            binding.btnPhonePayment.visibility = View.GONE
            binding.btnPhonePaymentChecked.visibility = View.VISIBLE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE

        }

        binding.btnPhonePaymentChecked.setOnClickListener {
            binding.btnPhonePaymentChecked.visibility = View.VISIBLE
            binding.btnPhonePayment.visibility = View.GONE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE

        }

        binding.btnRealtimeAccountTransfer.setOnClickListener {
            binding.btnRealtimeAccountTransfer.visibility = View.GONE
            binding.btnRealtimeAccountTransferChecked.visibility = View.VISIBLE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE

        }

        binding.btnRealtimeAccountTransferChecked.setOnClickListener {
            binding.btnRealtimeAccountTransferChecked.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransfer.visibility = View.GONE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE

        }

    }
}





