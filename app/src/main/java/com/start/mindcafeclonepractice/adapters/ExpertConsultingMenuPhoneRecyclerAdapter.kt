package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuPhoneData

class ExpertConsultingMenuPhoneRecyclerAdapter (
    val mContext: Context,
    val mList: ArrayList<ExpertConsultingMenuPhoneData>
        ):RecyclerView.Adapter<ExpertConsultingMenuPhoneRecyclerAdapter.PhoneViewHolder>() {

    interface OnItemClickListener{

        fun onItemClick(v: View, data: ExpertConsultingMenuPhoneData, position: Int)

    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){

            this.listener = listener
    }

    inner class PhoneViewHolder(row: View) : RecyclerView.ViewHolder(row){

        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
        val txtTimeMinutes = row.findViewById<TextView>(R.id.txtTimeMinutess)
        val txtExpiration = row.findViewById<TextView>(R.id.txtExpirations)

        fun bind(data: ExpertConsultingMenuPhoneData){
            txtTitle.text = data.title
            txtPrice.text = data.price?.let { data.getFormattedPrice(it) }

            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){

                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, data, position)
                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.consulting_menu_phone_list_item,parent,false)
        return PhoneViewHolder(row)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size

}