package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.ExpertProfileDetailIntroductionData

class ExpertProfileIntroductionAdapter(
    val mContext: Context,
    val mList: ArrayList<ExpertProfileDetailIntroductionData>
): RecyclerView.Adapter<ExpertProfileIntroductionAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(row: View): RecyclerView.ViewHolder(row){
        val txtCoachingScruple = row.findViewById<TextView>(R.id.txtCoachingScruple)
        val txtCoachingEffect = row.findViewById<TextView>(R.id.txtCoachingEffect)
        val txtCoachingStyle = row.findViewById<TextView>(R.id.txtCoachingStyle)

        fun bind( data: ExpertProfileDetailIntroductionData ){
            txtCoachingScruple.text = data.coachingScruple
            txtCoachingEffect.text = data.coachingEffect
            txtCoachingStyle.text = data.coachingStyle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.profie_detail_viewpager2_in1_list_item,parent,false)
        return  ProfileViewHolder(row)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}