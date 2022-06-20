package com.start.mindcafeclonepractice

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {



    }


    override fun setValues() {

    }
}