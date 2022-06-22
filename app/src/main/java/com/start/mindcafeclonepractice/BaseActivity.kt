package com.start.mindcafeclonepractice

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this


    }

    abstract fun setupEvents()

    abstract fun setValues()

    //커스텀 액션바 달아주는 함수 만들기.
    fun setCustomActionBarForMain(){

        //1) 기본 액션바 가져오기
        val defActionBar = supportActionBar!!

        //2) 가져온 액션바를 커스텀 모드로 변경
        defActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM

        //3) 실제 커스텀뷰를 어떤 모양(xml)로 할건지
        defActionBar.setCustomView(R.layout.my_custom_action_bar_main)

        //4) 좌우 여백 제거 : ToolBar 소환 -> 좌우 여백값 제거하기
        val toolBar = defActionBar.customView.parent as androidx.appcompat.widget.Toolbar
        toolBar.setContentInsetsAbsolute(0, 0)
    }

}