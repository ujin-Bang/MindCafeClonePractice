package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.CommunityContentData

class CommunityContentCheerRecyclerViewAdapter(
    val mContext:Context,
    val mList: List<CommunityContentData>
): RecyclerView.Adapter<CommunityContentCheerRecyclerViewAdapter.CheerViewHolder>() {

    inner class CheerViewHolder(row: View): RecyclerView.ViewHolder(row){
        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtContent = row.findViewById<TextView>(R.id.txtContent)
        val txtUid = row.findViewById<TextView>(R.id.txtUid)

        fun bind(data: CommunityContentData){
            txtTitle.text = data.title
            txtContent.text = data.content
            txtUid.text = data.uid
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheerViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.community_cheer_list_item, parent,false)
        return CheerViewHolder(row)
    }

    override fun onBindViewHolder(holder: CheerViewHolder, position: Int) {

         holder.bind(mList[position])
    }

    override fun getItemCount()= mList.size
}