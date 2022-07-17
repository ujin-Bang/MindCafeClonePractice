package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuPhoneData
import com.start.mindcafeclonepractice.datas.ExpertMenuPhoneData
import java.text.DecimalFormat

class ExpertMenuPhoneRecylerAdapter(
    val mContext: Context,
    val mList: List<ExpertMenuPhoneData>
): RecyclerView.Adapter<ExpertMenuPhoneRecylerAdapter.PhoneRecyclerViewHoler>() {

    interface OnItemClickListener{
        fun onClick(v: View, data: ExpertMenuPhoneData, position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){

        this.listener = listener

    }

    inner class PhoneRecyclerViewHoler(row: View): RecyclerView.ViewHolder(row){

        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtSeveralMinutesTime = row.findViewById<TextView>(R.id.txtSeveralMinutesTime)
        val txtExpirationPeriod = row.findViewById<TextView>(R.id.txtExpirationPeriod)
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)

        fun bind(data: ExpertMenuPhoneData){
            txtTitle.text = data.title
            txtSeveralMinutesTime.text = data.severalMinutesTime
            txtExpirationPeriod.text = data.expirationPeriod

            val dec = DecimalFormat("#,###")
            val priceStr = dec.format(data.price)
            txtPrice.text = "${priceStr}원"

            val positon = adapterPosition
            if (positon != RecyclerView.NO_POSITION){

                itemView.setOnClickListener {
                    listener?.onClick(itemView, data, positon)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneRecyclerViewHoler {

        val row = LayoutInflater.from(mContext).inflate(R.layout.phone_menu_list_item,parent,false)
        return PhoneRecyclerViewHoler(row)
    }

    override fun onBindViewHolder(holder: PhoneRecyclerViewHoler, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}