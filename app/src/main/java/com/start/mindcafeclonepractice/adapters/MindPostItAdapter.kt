package com.start.mindcafeclonepractice.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.datas.MindPostItData
import java.text.SimpleDateFormat
import java.util.*

class MindPostItAdapter(
    val mContext: Context,
    val mList: ArrayList<MindPostItData>
): RecyclerView.Adapter<MindPostItAdapter.MindPostItViewHolder>() {


    inner class MindPostItViewHolder(row: View): RecyclerView.ViewHolder(row){
        val txtContent = row.findViewById<TextView>(R.id.txtContent)
        val imgHeart = row.findViewById<ImageView>(R.id.imgHeart)
        val imgHeart2 = row.findViewById<ImageView>(R.id.imgHeart2)
        val txtHeartCount = row.findViewById<TextView>(R.id.txtHeartCount)
        val txtWriteTieme = row.findViewById<TextView>(R.id.txtWriteTime)


        val writeTime = MindPostItData()
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val mon = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val min = calendar.get(Calendar.MINUTE)
        val sec = calendar.get(Calendar.SECOND)


        val postData = MindPostItData()
        //작성시간 반환하는 함수
        fun writeTime(): String{
            calendar.set(year,mon,day,hour,min,sec)
            calendar.timeInMillis //설정된 시간을 밀리초로 변경

            //2001.07.04 12:08:56
         val sdf = SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.KOREA).format(calendar.timeInMillis)

            writeTime.writeTime = sdf
            txtWriteTieme.text = writeTime.writeTime.toString()

            return txtWriteTieme.toString()
        }

        fun heartCounter(){

            imgHeart.setOnClickListener {
                imgHeart.visibility = View.GONE
                imgHeart2.visibility = View.VISIBLE
                postData.sympathyCount = postData.sympathyCount.plus(1)
                txtHeartCount.text = postData.sympathyCount.toString()
                Toast.makeText(mContext, "공감하였습니다.", Toast.LENGTH_SHORT).show()

            }


            imgHeart2.setOnClickListener {


                imgHeart2.visibility = View.GONE
                imgHeart.visibility = View.VISIBLE
                postData.sympathyCount = postData.sympathyCount.minus(1)
                txtHeartCount.text = postData.sympathyCount.toString()
                Toast.makeText(mContext, "공감 취소하였습니다.", Toast.LENGTH_SHORT).show()

            }
        }



        fun bind( data: MindPostItData){
            txtContent.text = data.content
            writeTime()
            heartCounter()

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