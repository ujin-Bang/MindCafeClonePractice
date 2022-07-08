package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ExpertConsultingMenuChattData

class ExpertConsultingMenuChattRecyclerAdapter(
    val mContext: Context,
    val mList: ArrayList<ExpertConsultingMenuChattData>
): RecyclerView.Adapter<ExpertConsultingMenuChattRecyclerAdapter.MenuChattViewHolder>() {

    inner class MenuChattViewHolder(row: View): RecyclerView.ViewHolder(row){

        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
        val txtTimeMinutes = row.findViewById<TextView>(R.id.txtTimeMinutes)
        val txtExpiration = row.findViewById<TextView>(R.id.txtExpiration)


        fun bind(data: ExpertConsultingMenuChattData){
            txtTitle.text = data.title
            txtExpiration.text = data.expiration
            txtTimeMinutes.text = data.timeMinutes
            txtPrice.text = data.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuChattViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.expert_consulting_menu_chatt_list_item, parent,false)
        return MenuChattViewHolder(row)
    }

    override fun onBindViewHolder(holder: MenuChattViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}