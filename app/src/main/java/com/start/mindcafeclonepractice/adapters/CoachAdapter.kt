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
import com.start.mindcafeclonepractice.datas.CoachData

class CoachAdapter(val mContext: Context,val mList: ArrayList<CoachData>): RecyclerView.Adapter<CoachAdapter.CoachViewHolder>() {

    inner class CoachViewHolder(row: View): RecyclerView.ViewHolder(row) {

        val imgProfile = row.findViewById<ImageView>(R.id.imgProfile)
        val txtCoachName = row.findViewById<TextView>(R.id.txtCoachName)
        val txtCoachIntroduction = row.findViewById<TextView>(R.id.txtCoachIntroduction)
        val imgTalk = row.findViewById<ImageView>(R.id.imgTalk)
        val imgPhone = row.findViewById<ImageView>(R.id.imgPhone)
        val imgmeet = row.findViewById<ImageView>(R.id.imgMeet)

        fun bind(data: CoachData){

            txtCoachName.text = data.name
            txtCoachIntroduction.text = data.introduction
            Glide.with(mContext).load(data.profileImg).into(imgProfile)
            Glide.with(mContext).load(data.talkImg).into(imgTalk)
            Glide.with(mContext).load(data.phoneImg).into(imgPhone)
            Glide.with(mContext).load(data.meetImg).into(imgmeet)

        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoachViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.expert_list_item,parent,false)
        return CoachViewHolder(row)
    }

    override fun onBindViewHolder(holder: CoachViewHolder, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
       return mList.size
    }
}