package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.NewExpertData

class NewExpertAdapter(
    val mList: ArrayList<NewExpertData>,
    val mContext: Context): RecyclerView.Adapter<NewExpertAdapter.NewExpertViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(v:View, data: NewExpertData, pos : Int)
    }
    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    inner class NewExpertViewHolder(row: View): RecyclerView.ViewHolder(row) {

        val imgProfile = row.findViewById<ImageView>(R.id.imgProfile)
        val txtName = row.findViewById<TextView>(R.id.txtName)
        val txtIntroduction = row.findViewById<TextView>(R.id.txtIntroduction)
        val imgConsultingTool1 = row.findViewById<ImageView>(R.id.imgConsultingTool1)
        val imgConsultingTool2 = row.findViewById<ImageView>(R.id.imgConsultingTool2)

        fun bind( data: NewExpertData ){

            Glide.with(mContext).load(data.profileImg).into(imgProfile)
            txtName.text = data.name
            txtIntroduction.text = data.introduction
            Glide.with(mContext).load(data.consultingTool1).into(imgConsultingTool1)
            Glide.with(mContext).load(data.consultingTool2).into(imgConsultingTool2)

            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,data,pos)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewExpertViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.new_expert_list_item,parent,false)
        return NewExpertViewHolder(row)
    }

    override fun onBindViewHolder(holder: NewExpertViewHolder, position: Int) {

        holder.bind(mList[position])

    }

    override fun getItemCount(): Int {

        return mList.size
    }
}