package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.MindPostItData
import org.w3c.dom.Text

class MindPostItAdapter(
    val mContext: Context,
    val mList: ArrayList<MindPostItData>
): RecyclerView.Adapter<MindPostItAdapter.MindPostItViewHolder>() {

    inner class MindPostItViewHolder(row: View): RecyclerView.ViewHolder(row){
        val txtEmail = row.findViewById<TextView>(R.id.txtEmail)
        val txtContent = row.findViewById<TextView>(R.id.txtContent)
        val imgHeart = row.findViewById<ImageView>(R.id.imgHeart)
        val imgHeart2 = row.findViewById<ImageView>(R.id.imgHeart2)
        val txtHeartCount = row.findViewById<TextView>(R.id.txtHeartCount)



        fun bind( data: MindPostItData){
            txtEmail.text = data.email
            txtContent.text = data.content

            
            imgHeart.setOnClickListener { 
                imgHeart.visibility = View.GONE
                imgHeart2.visibility = View.VISIBLE

                Toast.makeText(mContext, "공감하였습니다.", Toast.LENGTH_SHORT).show()
            }
            
            imgHeart2.setOnClickListener { 
                imgHeart2.visibility = View.GONE
                imgHeart.visibility = View.VISIBLE
                Toast.makeText(mContext, "공감 취소하였습니다.", Toast.LENGTH_SHORT).show()
            }
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