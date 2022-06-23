package com.start.mindcafeclonepractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.BaseActivity
import com.start.mindcafeclonepractice.R
import com.start.mindcafeclonepractice.databinding.ActivityWriteNextButtonClickBinding

class WriteNextButtonClickActivity : BaseActivity() {

    lateinit var binding: ActivityWriteNextButtonClickBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_write_next_button_click)
    }



    override fun setupEvents() {

    }

    override fun setValues() {

    }
}