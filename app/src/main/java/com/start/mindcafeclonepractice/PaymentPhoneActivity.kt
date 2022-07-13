package com.start.mindcafeclonepractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityPaymentPhoneBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuPhoneData
import java.text.DecimalFormat

class PaymentPhoneActivity : BaseActivity() {

    lateinit var binding: ActivityPaymentPhoneBinding
    lateinit var mData: ExpertConsultingMenuPhoneData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment_phone)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        spinner()

        couponRegistration()

        methodPaymentSelect()
    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearlayoutPaymentPhoneActionBar.visibility = View.VISIBLE

        mData = intent.getSerializableExtra("data") as ExpertConsultingMenuPhoneData
        mTxtPaymentPhoneTitle.text = mData.title

        paymentMoney()

    }

    //스피너 클릭시
    fun spinner() {
        val spinnerList = arrayListOf(
            "쿠폰을 선택해주세요.",
            "10% 매달 첫째주 할인",
            "20% 방학할인",
            "10% 생일맞이 할인",
            "30% 개근상 할인",
            "10% 가족할인",
            "10% 친구추천 할인"
        )
        val spAdapter = ArrayAdapter<String>(
            mContext,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            spinnerList
        )
        binding.phoneCouponSpinner.adapter = spAdapter


        binding.phoneCouponSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    if (parent != null) {

                        Log.d("스피너 아이템 선택: ", "${parent.selectedItem}을 선택했습니다..")
//                    Toast.makeText(mContext, "${parent.selectedItem} ", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
    }

    //쿠폰등록 -> alertDialog 커스터마이징해서 활용
    fun couponRegistration() {
        binding.btnCouponRegistration.setOnClickListener {

            //만들어 놓은 얼럿창 xml 가져오기
            val customAlert = LayoutInflater.from(mContext)
                .inflate(R.layout.payment_phone_coupon_custom_alertdialog, null)

            val alert = AlertDialog.Builder(mContext)
                .setView(customAlert)//커스텀한 얼럿창으로 세팅
                .create()

            //아이디 찾아서 변수에 저장
            val btnXPhone = customAlert.findViewById<ImageView>(R.id.btnXPhone)
            val btnCouponCode1 = customAlert.findViewById<TextView>(R.id.btnCouponCode1)
            val btnCouponCode2 = customAlert.findViewById<TextView>(R.id.btnCouponCode2)
            val btnCouponName1 = customAlert.findViewById<TextView>(R.id.btnCouponName1)
            val btnCouponName2 = customAlert.findViewById<TextView>(R.id.btnCouponName2)
            val txtCouponCode = customAlert.findViewById<TextView>(R.id.txtCouponCode)
            val txtCouponName = customAlert.findViewById<TextView>(R.id.txtCouponName)
            val edtCouponCode = customAlert.findViewById<EditText>(R.id.edtCouponCode)
            val edtCouponName = customAlert.findViewById<EditText>(R.id.edtCouponName)
            val btnCouponIssued = customAlert.findViewById<Button>(R.id.btnCouponIssued)


            btnXPhone.setOnClickListener {
                alert.dismiss()//x버튼 누르면 얼럿창 닫힘
            }

            btnCouponCode2.setOnClickListener {
                btnCouponCode2.visibility = View.VISIBLE
                btnCouponCode1.visibility = View.GONE
                btnCouponName1.visibility = View.VISIBLE
                btnCouponName2.visibility = View.GONE

            }

            btnCouponCode1.setOnClickListener {
                btnCouponCode1.visibility = View.GONE
                btnCouponCode2.visibility = View.VISIBLE
                btnCouponName1.visibility = View.VISIBLE
                btnCouponName2.visibility = View.GONE
                txtCouponCode.text = "쿠폰 코드를 입력해주세요."
                edtCouponCode.visibility = View.VISIBLE
                edtCouponName.visibility = View.GONE

            }

            btnCouponName1.setOnClickListener {
                btnCouponName1.visibility = View.GONE
                btnCouponName2.visibility = View.VISIBLE
                btnCouponCode1.visibility = View.VISIBLE
                btnCouponCode2.visibility = View.GONE
                txtCouponCode.text = "쿠폰 이름을 입력해주세요."
                edtCouponCode.visibility = View.GONE
                edtCouponName.visibility = View.VISIBLE

            }

            btnCouponName2.setOnClickListener {
                btnCouponName2.visibility = View.VISIBLE
                btnCouponName1.visibility = View.GONE
                btnCouponCode1.visibility = View.VISIBLE
                btnCouponCode2.visibility = View.GONE

            }

//            쿠폰발급버튼 클릭이벤트처리
            btnCouponIssued.setOnClickListener {
                if (btnCouponCode2.visibility == View.VISIBLE) {

                    if (edtCouponCode.length() == 0 || edtCouponCode.length() < 16) {
                        Toast.makeText(mContext, "투폰코드 16자리를 입력해주세요.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                }
                if (btnCouponName2.visibility == View.VISIBLE) {

                    if (edtCouponName.length() == 0) {
                        Toast.makeText(mContext, "쿠폰이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
            }

            alert.show()

        }
    }


    //결제수단 선택하기
    fun methodPaymentSelect() {

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

        binding.btnRealtimeAccountTransfer.setOnClickListener {
            binding.btnRealtimeAccountTransfer.visibility = View.GONE
            binding.btnRealtimeAccountTransferChecked.visibility = View.VISIBLE
            binding.btnPhonePayment.visibility = View.VISIBLE
            binding.btnPhonePaymentChecked.visibility = View.GONE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE
        }
    }

    //최종결제금액 받아온 데이터로 표현하기
    fun paymentMoney() {
        val dec = DecimalFormat("#,###")
        val normalPrice = mData.normalPrice
        val normalPriceStr = dec.format(normalPrice)

        binding.txtNormalPrice.text = "${normalPriceStr}원" //정상가 받아온 데이터에 3자리마다 콤마 찍어서 표현

        val discountMoney5DC = (normalPrice?.times(0.05))?.toInt()

        val discountMoney10DC = (normalPrice?.times(0.1))?.toInt()

        if (normalPrice != null) {

            if((normalPrice > 100000) && (200000 > normalPrice)){

                    binding.txtDiscountPrice.text = "-${dec.format(discountMoney5DC)}원"

                val resultPayment = discountMoney5DC?.let { normalPrice?.minus(it) }
                binding.txtResultPrice.text = "${dec.format(resultPayment)}원"

            }

            else if(normalPrice in 200000..2000000){

                binding.txtDiscountPrice.text = "-${dec.format(discountMoney10DC)}원"
                val resultPayment = discountMoney10DC?.let { normalPrice?.minus(it) }
                binding.txtResultPrice.text = "${dec.format(resultPayment)}원"
            }

            else {
                binding.txtDiscountPrice.text = "0원"
                binding.txtResultPrice.text = "${normalPriceStr}원"
            }
        }





    }
}