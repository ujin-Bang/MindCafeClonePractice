package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.UserData

class MakasRecylerAdapter(
    private val mContext: Context,
    private val mList: ArrayList<UserData>): RecyclerView.Adapter<MakasRecylerAdapter.MakasViewHolder>() {

    inner class MakasViewHolder(row: View): RecyclerView.ViewHolder(row) {

        val txtname = row.findViewById<TextView>(R.id.txtName)
        val txttitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtcontent = row.findViewById<TextView>(R.id.txtContent)
        val txtworry = row.findViewById<TextView>(R.id.txtWorry)

        fun bind(data : UserData){

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakasViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.makas_list_item, parent, false)
        return MakasViewHolder(row)
    }

    override fun onBindViewHolder(holder: MakasViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}