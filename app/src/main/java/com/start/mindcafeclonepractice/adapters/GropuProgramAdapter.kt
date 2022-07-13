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
import com.start.mindcafeclonepractice.datas.GroupProgramData

class GropuProgramAdapter(val mContext:Context, val mList: ArrayList<GroupProgramData>): RecyclerView.Adapter<GropuProgramAdapter.GroupProgramViewHolder>() {

    //리싸이클러뷰 아이템 클릭시 인터페이스 호출하기 위해 인터페이스 만들기
    interface OnItemClickListener{
        fun onItemClick(v: View, data: GroupProgramData, position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){

        this.listener = listener
    }

    inner class GroupProgramViewHolder(row: View): RecyclerView.ViewHolder(row){

        val imgGroupProgram = row.findViewById<ImageView>(R.id.imgGroupProgram)
        val txtTitle = row.findViewById<TextView>(R.id.txtTitle)
        val txtTime = row.findViewById<TextView>(R.id.txtTime)
        val txtCoachName = row.findViewById<TextView>(R.id.txtCoachName)

        fun bind(data: GroupProgramData){
            Glide.with(mContext).load(data.programImg).into(imgGroupProgram)
            txtTitle.text = data.programTitle
            txtTime.text = data.programTime
            txtCoachName.text = data.programCoachName

            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){

                itemView.setOnClickListener {

                    listener?.onItemClick(itemView, data, position)

                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupProgramViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.group_program_item,parent,false)
        return GroupProgramViewHolder(row)
    }

    override fun onBindViewHolder(holder: GroupProgramViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}