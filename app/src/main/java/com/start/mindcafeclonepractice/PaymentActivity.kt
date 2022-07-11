package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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

    override fun setupEvents() {

        val customList = arrayListOf("쿠폰선택","10% 할인","20% 할인","여름 방학 할인","주중 할인","공휴일 할인","1년 할인")
        val adapter = ArrayAdapter<String>(mContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,customList)
        binding.couponSpinner.adapter = adapter

        binding.couponSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if(position == 0 ){
                    Toast.makeText(mContext, "쿠폰을 선택해 주세요.", Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(mContext, "${parent?.selectedItem.toString()}쿠폰선택, 위치: ${position}", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }

    override fun setValues() {
        mData = intent.getSerializableExtra("data") as ExpertConsultingMenuChattData

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutPaymentActionBar.visibility = View.VISIBLE
        mTxtPaymentTitle.text = mData.title
    }
}