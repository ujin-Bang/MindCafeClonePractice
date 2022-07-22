package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        val txtReplyCount = row.findViewById<TextView>(R.id.txtReplyCount)
        val txtLike = row.findViewById<TextView>(R.id.txtLike)
        val txtDisLike = row.findViewById<TextView>(R.id.txtDisLike)
        val imgLike = row.findViewById<ImageView>(R.id.imgLike)
        val imgHate = row.findViewById<ImageView>(R.id.imgHate)


        fun bind(data: CommunityContentData){
            txtTitle.text = data.title
            txtContent.text = data.content
            txtUid.text = data.uid
            txtReplyCount.text = data.replyCount.toString()
            txtLike.text = data.likeCount.toString()
            txtDisLike.text = data.hateCount.toString()

            var clicked = false
            var likeCount =0
            var hateCount = 0
            imgLike.setOnClickListener {

                if (!clicked){
                    imgLike.setImageResource(R.drawable.heart_icon_3)
                   val lc =  ++likeCount
                    txtLike.text = lc.toString()
                    clicked = true
                }
                else{
                    imgLike.setImageResource(R.drawable.heart_icon)
                     val lc2 = --likeCount
                    txtLike.text = lc2.toString()
                    clicked = false
                }

            }

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