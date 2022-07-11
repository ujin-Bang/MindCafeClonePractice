package com.start.mindcafeclonepractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.adapters.ExpertConsultingMenuChattRecyclerAdapter
import com.start.mindcafeclonepractice.databinding.ActivityPaymentBinding
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuChattData

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
            val btnCouponissued = customDialog.findViewById<TextView>(R.id.btnCouponIssued)


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

            }

            btnCouponCode2.setOnClickListener {

                btnCouponCode.visibility = View.VISIBLE
                btnCouponCode2.visibility = View.GONE
                btnCouponName.visibility = View.VISIBLE
                btnCouponName2.visibility = View.GONE
                edtCouponCode.visibility = View.VISIBLE
                edtCouponName.visibility = View.GONE

            }

            btnCouponName.setOnClickListener {

                btnCouponName.visibility = View.GONE
                btnCouponName2.visibility = View.VISIBLE
                btnCouponCode.visibility = View.GONE
                btnCouponCode2.visibility = View.VISIBLE
                edtCouponCode.visibility = View.GONE
                edtCouponName.visibility = View.VISIBLE


            }

            btnCouponName2.setOnClickListener {

                btnCouponName.visibility = View.GONE
                btnCouponName2.visibility = View.VISIBLE
                btnCouponCode.visibility = View.GONE
                btnCouponCode2.visibility = View.VISIBLE
                edtCouponCode.visibility = View.GONE
                edtCouponName.visibility = View.VISIBLE

            }

                alert.show()

            }


        }

        override fun setValues() {
            mData = intent.getSerializableExtra("data") as ExpertConsultingMenuChattData

            mLinearLayoutMainActionBar.visibility = View.GONE
            mLinearLayoutPaymentActionBar.visibility = View.VISIBLE
            mTxtPaymentTitle.text = mData.title
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
    }
