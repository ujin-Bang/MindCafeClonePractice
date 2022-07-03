package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ConsultingMenuChattingData
import java.text.DecimalFormat

class ConsultingMenuChattingDataRecyclerAdapter(
    val mContext:Context,
    val mList: ArrayList<ConsultingMenuChattingData>
    ):RecyclerView.Adapter<ConsultingMenuChattingDataRecyclerAdapter.ConsultingMenuViewHolder>() {

    inner class ConsultingMenuViewHolder(row: View): RecyclerView.ViewHolder(row){

        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtSeveralMinutesTime = row.findViewById<TextView>(R.id.txtSeveralMinutesTime)
        val txtExpirationPeriod = row.findViewById<TextView>(R.id.txtExpirationPeriod)
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)

        fun bind(data: ConsultingMenuChattingData){
            txtTitle.text = data.title
            txtSeveralMinutesTime.text = data.severalMinutesTime
            txtExpirationPeriod.text = data.expirationPeriod

            val pri = DecimalFormat("#,###")
            txtPrice.text = "${pri.format(data.price)}원"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultingMenuViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.consulting_menu_chatting_list_item,parent,false)
        return ConsultingMenuViewHolder(row)
    }

    override fun onBindViewHolder(holder: ConsultingMenuViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size


}