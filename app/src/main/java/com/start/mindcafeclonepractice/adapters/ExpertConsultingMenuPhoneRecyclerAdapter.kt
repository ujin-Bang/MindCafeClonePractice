package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuPhoneData
import org.w3c.dom.Text

class ExpertConsultingMenuPhoneRecyclerAdapter (
    val mContext: Context,
    val mList: ArrayList<ExpertConsultingMenuPhoneData>
        ):RecyclerView.Adapter<ExpertConsultingMenuPhoneRecyclerAdapter.PhoneViewHolder>() {

    inner class PhoneViewHolder(row: View) : RecyclerView.ViewHolder(row){
        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
        val txtTimeMinutes = row.findViewById<TextView>(R.id.txtTimeMinutes)
        val txtExpiration = row.findViewById<TextView>(R.id.txtExpiration)

        fun bind(data: ExpertConsultingMenuPhoneData){
            txtTitle.text = data.title
            txtExpiration.text = data.expiration
            txtPrice.text = data.price.toString()
            txtTimeMinutes.text = data.timeMinutes
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {

        val span = LayoutInflater.from(mContext).inflate(R.layout.fragment_expert_consulting_menu_phone,parent,false)
        return PhoneViewHolder(span)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {

        holder.bind(mList[position])

    }

    override fun getItemCount() = mList.size
}