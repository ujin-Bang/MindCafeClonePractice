package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ConsultingMenuPhoneData
import java.text.DecimalFormat

class ConsultingMenuPhoneDataRecylerAdapter(
    val mList: ArrayList<ConsultingMenuPhoneData>,
    val mContext: Context
): RecyclerView.Adapter<ConsultingMenuPhoneDataRecylerAdapter.PhoneDataViewHolder>() {

    inner class PhoneDataViewHolder(row: View): RecyclerView.ViewHolder(row) {

        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtSeveralMinutesTime = row.findViewById<TextView>(R.id.txtSeveralMinutesTime)
        val txtExpirationPeriod = row.findViewById<TextView>(R.id.txtExpirationPeriod)
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)

        fun bind( data: ConsultingMenuPhoneData){
            txtTitle.text = data.title
            txtSeveralMinutesTime.text = data.severalMinutesTime
            txtExpirationPeriod.text = data.expirationPeriod

            val pri = DecimalFormat("#,###")
            txtPrice.text = "${pri.format(data.price)}원"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneDataViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.consulting_menu_phone_list_item,parent, false)
        return PhoneDataViewHolder(row)
    }

    override fun onBindViewHolder(holder: PhoneDataViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}