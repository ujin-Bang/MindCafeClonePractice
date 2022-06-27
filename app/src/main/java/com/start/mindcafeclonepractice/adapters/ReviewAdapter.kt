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
import com.start.mindcafeclonepractice.datas.ReviewData
import org.w3c.dom.Text

class ReviewAdapter(val mList: ArrayList<ReviewData>, val mContext: Context): RecyclerView.Adapter<ReviewAdapter.ReviewHolderView>() {

    inner class ReviewHolderView(row: View): RecyclerView.ViewHolder(row) {

        val imgCoachProfile = row.findViewById<ImageView>(R.id.imgCoachProfile)
        val txtCoachName = row.findViewById<TextView>(R.id.txtCoachName)
        val imgRating = row.findViewById<ImageView>(R.id.imgRating)
        val txtRaging = row.findViewById<TextView>(R.id.txtRaging)
        val imgSolutionState = row.findViewById<ImageView>(R.id.imgSolutionState)
        val txtPurchaseProduct = row.findViewById<TextView>(R.id.txtPurchaseProduct)
        val txtContent = row.findViewById<TextView>(R.id.txtContent)

        fun bind( data: ReviewData){
            Glide.with(mContext).load(data.profileImg).into(imgCoachProfile)
            txtCoachName.text = data.coachName
            Glide.with(mContext).load(data.ratingImg).into(imgRating)
            txtRaging.text = data.ratingNum.toString()
            Glide.with(mContext).load(data.solutionImg).into(imgSolutionState)
            txtPurchaseProduct.text = data.purchaseProduct
            txtContent.text = data.content
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolderView {
        val row = LayoutInflater.from(mContext).inflate(R.layout.review_list_item, parent, false)
        return ReviewHolderView(row)
    }

    override fun onBindViewHolder(holder: ReviewHolderView, position: Int) {

        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {

        return mList.size
    }
}