package com.start.mindcafeclonepractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context

    //xml에 아이디 부여 액션바 사용하는 액티비티에서 커스텀 하기 위해 멤버변수로 지정.
    lateinit var mLinearLayoutMainActionBar: LinearLayout
    lateinit var mLinearLayoutWriteActionbar: LinearLayout
    lateinit var mLinearLayoutNewExpertActionbar: LinearLayout

    lateinit var mBtnBack: TextView
    lateinit var mBtnNext: TextView
    lateinit var mBtnBack2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

        //      액션바가 있는 화면에서만 실행.
        supportActionBar?.let {

//            supportActionBar 이 변수가 null 아닐때만 해달라는 코드.
            setCustomActionBar()
        }

    }

    abstract fun setupEvents()

    abstract fun setValues()

    //커스텀 액션바 달아주는 함수 만들기.
    fun setCustomActionBar() {

        //1) 기본 액션바 가져오기
        val defActionBar = supportActionBar!!

        //2) 가져온 액션바를 커스텀 모드로 변경
        defActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM

        //3) 실제 커스텀뷰를 어떤 모양(xml)로 할건지
        defActionBar.setCustomView(R.layout.my_custom_action_bar_main)

        //4) 좌우 여백 제거 : ToolBar 소환 -> 좌우 여백값 제거하기
        val toolBar = defActionBar.customView.parent as androidx.appcompat.widget.Toolbar
        toolBar.setContentInsetsAbsolute(0, 0)

        //멤버변수로 지정된 아이디 객체로 만들기( 버튼이미지는 기능부여)
        mLinearLayoutMainActionBar = defActionBar.customView.findViewById(R.id.mainActionBar)
        mLinearLayoutWriteActionbar = defActionBar.customView.findViewById(R.id.writeActionBar)
        mLinearLayoutNewExpertActionbar = defActionBar.customView.findViewById(R.id.newExpertProfileActionbar)

        mBtnBack = defActionBar.customView.findViewById(R.id.btnBack)
        mBtnNext = defActionBar.customView.findViewById(R.id.btnNext)
        mBtnBack2 = defActionBar.customView.findViewById(R.id.btnBack2)

        mBtnBack.setOnTouchListener { v, event ->

            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    mBtnBack.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.teal
                        )
                    )
                }


                MotionEvent.ACTION_MOVE -> {
                    mBtnBack.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.teal
                        )
                    )

                }

                MotionEvent.ACTION_UP -> {
                    finish()
                }


                else -> {

                }
            }
            true

        }



        mBtnNext.setOnTouchListener { v, event ->

            when (event.action) {

                MotionEvent.ACTION_DOWN -> {

                    mBtnNext.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.teal
                        )
                    )
                }

                MotionEvent.ACTION_MOVE -> {

                    mBtnNext.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.teal
                        )
                    )

                }

                MotionEvent.ACTION_UP -> {
                    val myIntent = Intent(mContext, WriteNextButtonClickActivity::class.java)
                    startActivity(myIntent)

                    finish()

                }

                else -> {
                }
            }
            true
        }
    }


}
