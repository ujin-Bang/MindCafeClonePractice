package com.start.mindcafeclonepractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityGroupPaymentBinding
import com.start.mindcafeclonepractice.datas.GroupProgramData
import java.text.DecimalFormat

class GroupPaymentActivity : BaseActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityGroupPaymentBinding
    lateinit var mData: GroupProgramData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_group_payment)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        spinner()

        binding.couponRegistration.setOnClickListener {

            val customAlert = LayoutInflater.from(mContext)
                .inflate(R.layout.group_program_coupon_alert_custom, null)

            val alert = AlertDialog.Builder(mContext)
                .setView(customAlert)
                .create()

            val btnX = customAlert.findViewById<ImageView>(R.id.btnGroupRegistrationX)
            val btnCouponCodeChecked = customAlert.findViewById<TextView>(R.id.btnCouponCodeChecked)
            val btnCouponCode = customAlert.findViewById<TextView>(R.id.btnCouponCode)
            val btnCouponNameChecked = customAlert.findViewById<TextView>(R.id.btnCouponNameChecked)
            val btnCouponName = customAlert.findViewById<TextView>(R.id.btnCouponName)
            val txtCouponCode = customAlert.findViewById<TextView>(R.id.txtCouponCode)

            val layoutEdtCouponCode =
                customAlert.findViewById<LinearLayout>(R.id.layoutEdtCouponCode)
            val layoutEdtCouponName =
                customAlert.findViewById<LinearLayout>(R.id.layoutEdtCouponName)
            val edtCouponCode = customAlert.findViewById<EditText>(R.id.edtCouponCode)
            val edtCouponName = customAlert.findViewById<EditText>(R.id.edtCouponName)
            val btnCouponIssued = customAlert.findViewById<Button>(R.id.btnCouponIssued)

            btnX.setOnClickListener {
                alert.dismiss()
            }

            btnCouponCode.setOnClickListener {
                btnCouponCode.visibility = View.GONE
                btnCouponCodeChecked.visibility = View.VISIBLE
                btnCouponName.visibility = View.VISIBLE
                btnCouponNameChecked.visibility = View.GONE
                txtCouponCode.text = "쿠폰코드를 입력해주세요."
                layoutEdtCouponCode.visibility = View.VISIBLE
                layoutEdtCouponName.visibility = View.GONE
            }

            btnCouponName.setOnClickListener {
                btnCouponName.visibility = View.GONE
                btnCouponNameChecked.visibility = View.VISIBLE
                btnCouponCode.visibility = View.VISIBLE
                btnCouponCodeChecked.visibility = View.GONE
                txtCouponCode.text = "쿠폰이름을 입력해주세요."
                layoutEdtCouponCode.visibility = View.GONE
                layoutEdtCouponName.visibility = View.VISIBLE
            }

            btnCouponIssued.setOnClickListener {
                if (btnCouponCodeChecked.visibility == View.VISIBLE) {
                    if (edtCouponCode.length() < 17) {
                        Toast.makeText(mContext, "쿠폰코드는 16자리 숫자로 입력해주세요.", Toast.LENGTH_SHORT)
                            .show()
                        return@setOnClickListener
                    }
                }
                if (btnCouponNameChecked.visibility == View.VISIBLE) {
                    if (edtCouponName.length() == 0) {
                        Toast.makeText(mContext, "쿠폰이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }

            }
            alert.show()
        }

        paymentMethod()

        binding.btnPaymentOk.setOnClickListener {
            startActivity(Intent(mContext, FinalPaymentPageActivity::class.java))
        }

    }

    override fun setValues() {

        mData = intent.getSerializableExtra("paymentData") as GroupProgramData //받은 데이터 변수에 담기

        //상속받은 액션바 재설정
        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE

        mTxtPaymentTitle.text = mData.programTitle
        binding.couponSpinner2.onItemSelectedListener = this

        val normalPrice = mData.price
        val dec = DecimalFormat("#,###")
        val normalPriceStr = dec.format(normalPrice)
        binding.txtGroupNormalPrice.text = "${normalPriceStr}원"
        binding.txtGroupFinalAmount.text = "${normalPriceStr}원"

    }

    fun spinner() {

        ArrayAdapter.createFromResource(
            mContext,
            R.array.coupon3,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                binding.couponSpinner2.adapter = adapter
            }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Log.d("선택된 스피너 아이템 : ", parent?.selectedItem.toString())
//        Toast.makeText(mContext, "${parent?.selectedItem} 선택", Toast.LENGTH_SHORT).show()
        val selectedItemName = parent?.selectedItem

        if (parent?.selectedItemPosition != 0){

            val dec = DecimalFormat("#,###")
            val price = mData.price
            val discountPrice = price?.times(0.1)
            val resultPrice = discountPrice?.let { price?.minus(it) }

            binding.txtGroupDiscountPrice.text = "${selectedItemName}_10%할인 : -${dec.format(discountPrice)}원"

            binding.txtGroupFinalAmount.text = "${dec.format(resultPrice)}원"

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    fun paymentMethod(){
        binding.btnCreditCard.setOnClickListener {
            binding.btnCreditCard.visibility = View.GONE
            binding.btnCreditCardChecked.visibility = View.VISIBLE
            binding.btnPaymentPhone.visibility = View.VISIBLE
            binding.btnPaymentPhoneChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE
        }

        binding.btnPaymentPhone.setOnClickListener {
            binding.btnPaymentPhone.visibility = View.GONE
            binding.btnPaymentPhoneChecked.visibility = View.VISIBLE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE
            binding.btnRealtimeAccountTransfer.visibility = View.VISIBLE
            binding.btnRealtimeAccountTransferChecked.visibility = View.GONE
        }

        binding.btnRealtimeAccountTransfer.setOnClickListener {
            binding.btnRealtimeAccountTransfer.visibility = View.GONE
            binding.btnRealtimeAccountTransferChecked.visibility = View.VISIBLE
            binding.btnPaymentPhone.visibility = View.VISIBLE
            binding.btnPaymentPhoneChecked.visibility = View.GONE
            binding.btnCreditCard.visibility = View.VISIBLE
            binding.btnCreditCardChecked.visibility = View.GONE
        }
    }
}