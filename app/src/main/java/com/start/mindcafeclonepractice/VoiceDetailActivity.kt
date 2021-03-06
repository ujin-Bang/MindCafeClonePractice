package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityVoiceDetailBinding

class VoiceDetailActivity : BaseActivity() {

    lateinit var binding: ActivityVoiceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_voice_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutOriginNoticeActionBar.visibility = View.VISIBLE
        mOrignTitle.text = "보이스"

    }
}