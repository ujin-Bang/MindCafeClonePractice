package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ExpertMenuChattData
import java.text.DecimalFormat

class ExpertMenuChatRecylerAdapter(
    val mContext: Context,
    val mList: List<ExpertMenuChattData>
): RecyclerView.Adapter<ExpertMenuChatRecylerAdapter.MenuChatViewHolder>() {

    interface OnItemClickListener{
        fun onClick(v:View, data: ExpertMenuChattData, position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    inner class MenuChatViewHolder(row: View): RecyclerView.ViewHolder(row){

        val ticketTitle = row.findViewById<TextView>(R.id.ticketTitle)
        val timeMinutes = row.findViewById<TextView>(R.id.timeMinutes)
        val expiration = row.findViewById<TextView>(R.id.expiration)
        val price = row.findViewById<TextView>(R.id.price)

        fun bind(data: ExpertMenuChattData){

            ticketTitle.text = data.title
            timeMinutes.text = data.severalMinutesTime
            expiration.text = data.expirationPeriod

            val dec = DecimalFormat("#,###")
            val priceStr = dec.format(data.price)
            price.text = "${priceStr}원"

            val pos = adapterPosition
            if ( pos != RecyclerView.NO_POSITION){

                itemView.setOnClickListener {
                    listener?.onClick(itemView, data, pos)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuChatViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.chat_menu_list_item, parent,false)
            return MenuChatViewHolder(row)
    }

    override fun onBindViewHolder(holder: MenuChatViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}