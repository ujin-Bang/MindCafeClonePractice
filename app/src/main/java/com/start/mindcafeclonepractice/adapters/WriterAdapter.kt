package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.WriterData

class WriterAdapter(val mContext: Context,val mList: ArrayList<WriterData>) : RecyclerView.Adapter<WriterAdapter.WriterViewHolder>() {

    inner class WriterViewHolder(row: View): RecyclerView.ViewHolder(row){

        val txtWorry = row.findViewById<TextView>(R.id.txtWorry)
        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtName = row.findViewById<TextView>(R.id.txtName)
        val txtContet = row.findViewById<TextView>(R.id.txtContent)

        fun bind(data: WriterData){
            txtWorry?.text = data.worry
            txtTitle?.text = data.title
            txtName?.text = data.name
            txtContet?.text = data.content
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriterViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.makas_list_item, parent, false)
        return WriterViewHolder(row)
    }

    override fun onBindViewHolder(holder: WriterViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}