package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.CommunityTitleData
import com.start.mindcafeclonepractice.datas.WorryData

class WorryRecyclerAdapter(
    val mContext: Context,
    val mList: List<WorryData>
): RecyclerView.Adapter<WorryRecyclerAdapter.WorryViewHolder>() {

    inner class WorryViewHolder(row: View): RecyclerView.ViewHolder(row){

        val txtWorry = row.findViewById<TextView>(R.id.txtWorry)

        fun bind(data: WorryData){
            txtWorry.text = data.worry
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorryViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.writing_worry_list_item,parent, false)
        return WorryViewHolder(row)
    }

    override fun onBindViewHolder(holder: WorryViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount() = mList.size
}