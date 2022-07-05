package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.MindPostItData

class MindPostItAdapter(
    val mContext: Context,
    val mList: ArrayList<MindPostItData>
): RecyclerView.Adapter<MindPostItAdapter.MindPostItViewHolder>() {

    inner class MindPostItViewHolder(row: View): RecyclerView.ViewHolder(row){
        val txtEmail = row.findViewById<TextView>(R.id.txtEmail)
        val txtContent = row.findViewById<TextView>(R.id.txtContent)

        fun bind( data: MindPostItData){
            txtEmail.text = data.email
            txtContent.text = data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MindPostItViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.mind_postit_list_item,parent,false)
        return MindPostItViewHolder(row)
    }

    override fun onBindViewHolder(holder: MindPostItViewHolder, position: Int) {

        holder.bind(mList[position])

    }

    override fun getItemCount() = mList.size
}