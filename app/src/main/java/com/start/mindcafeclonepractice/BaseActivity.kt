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
import org.w3c.dom.Text


abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context

    //xml에 아이디 부여 액션바 사용하는 액티비티에서 커스텀 하기 위해 멤버변수로 지정.
    lateinit var mLinearLayoutMainActionBar: LinearLayout
    lateinit var mLinearLayoutWriteActionbar: LinearLayout
    lateinit var mLinearLayoutNewExpertActionbar: LinearLayout
    lateinit var mLinearLayoutNewExpertSelectedConsultingMenu: LinearLayout
    lateinit var mLinearLayoutQandAActionBar: LinearLayout
    lateinit var mLinearLayoutNoticeActionBar: LinearLayout
    lateinit var mLinearLayoutOriginNoticeActionBar: LinearLayout
    lateinit var mlinearLayoutMindPostItActionBar: LinearLayout
    lateinit var mLinearLayoutReviewDetailActionBar: LinearLayout

    lateinit var mBtnBack: TextView
    lateinit var mBtnNext: TextView
    lateinit var mBtnBack2: ImageView
    lateinit var mBtnBack3: ImageView
    lateinit var mSelectedExpertName: TextView
    lateinit var mSetImg: ImageView
    lateinit var mXBackImg: ImageView
    lateinit var mBtnNotice: ImageView
    lateinit var mNoticeTitle: TextView
    lateinit var mOriginBtnX: ImageView
    lateinit var mOrignTitle: TextView
    lateinit var mMindPostItBack: ImageView
    lateinit var mMindPostItTitile: TextView
    lateinit var mTxtBackX: TextView
    lateinit var mReviewTitle: TextView

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
        mLinearLayoutNewExpertSelectedConsultingMenu = defActionBar.customView.findViewById(R.id.newExpertSelectedConsultingMenu)
        mLinearLayoutQandAActionBar = defActionBar.customView.findViewById(R.id.qAndAActionBar)
        mLinearLayoutNoticeActionBar = defActionBar.customView.findViewById(R.id.noticeActionBar)
        mLinearLayoutOriginNoticeActionBar = defActionBar.customView.findViewById(R.id.noticeOriginActionBar)
        mlinearLayoutMindPostItActionBar = defActionBar.customView.findViewById(R.id.mindPostItActionBar)
        mLinearLayoutReviewDetailActionBar = defActionBar.customView.findViewById(R.id.reviewDetailActionBar)

        mBtnBack = defActionBar.customView.findViewById(R.id.btnBack)
        mBtnNext = defActionBar.customView.findViewById(R.id.btnNext)
        mBtnBack2 = defActionBar.customView.findViewById(R.id.btnBack2)
        mBtnBack3 = defActionBar.customView.findViewById(R.id.btnBack3)
        mSelectedExpertName = defActionBar.customView.findViewById(R.id.txtSelectName)
        mXBackImg = defActionBar.customView.findViewById(R.id.imgX)
        mSetImg = defActionBar.customView.findViewById(R.id.imgSet)
        mNoticeTitle = defActionBar.customView.findViewById(R.id.txtNotice)
        mBtnNotice = defActionBar.customView.findViewById(R.id.btnNoticeBack)
        mOriginBtnX = defActionBar.customView.findViewById(R.id.btnOriginX)
        mOrignTitle = defActionBar.customView.findViewById(R.id.txtNoticeOrigin)
        mMindPostItBack = defActionBar.customView.findViewById(R.id.btnMindPostItBack)
        mMindPostItTitile = defActionBar.customView.findViewById(R.id.txtMindPostIt)
        mTxtBackX = defActionBar.customView.findViewById(R.id.txtBackX)
        mReviewTitle = defActionBar.customView.findViewById(R.id.txtConsultingTitle)



        mTxtBackX.setOnClickListener {
            finish()
        }

        mMindPostItBack.setOnClickListener {

            finish()
        }
        mOriginBtnX.setOnClickListener {
            finish()
        }


        mBtnNotice.setOnClickListener {

            startActivity(Intent(mContext,OriginalNoticeActivity::class.java))
            finish()
        }

        mBtnBack3.setOnClickListener {
            finish()
        }


        mBtnBack2.setOnClickListener {
            finish()
        }



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
