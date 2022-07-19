package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.CommunityTitleData

class CommunityRecyclerAdatpter(
    val mContext: Context,
    val mList: List<CommunityTitleData>
): RecyclerView.Adapter<CommunityRecyclerAdatpter.CommunityViewHoler>() {

    interface OnItemClickListener{
        fun onClick( v: View, data: CommunityTitleData, position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    inner class CommunityViewHoler(row: View): RecyclerView.ViewHolder(row){

        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtSmallTile = row.findViewById<TextView>(R.id.txtSmallTitle)

        fun bind(data: CommunityTitleData){
            txtTitle.text = data.title
            txtSmallTile.text = data.smallTitle

            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION){

                itemView.setOnClickListener {
                    listener?.onClick(itemView, data, pos)

                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHoler {

        val row = LayoutInflater.from(mContext).inflate(R.layout.community_title_list_item,parent,false)
        return CommunityViewHoler(row)
    }

    override fun onBindViewHolder(holder: CommunityViewHoler, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}