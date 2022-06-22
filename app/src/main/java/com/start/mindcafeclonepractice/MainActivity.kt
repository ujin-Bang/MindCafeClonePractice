package com.start.mindcafeclonepractice


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setCustomActionBarForMain()
    }

    override fun setupEvents() {

        binding.btnLogout.setOnClickListener {

        }

    }

    override fun setValues() {

    }
}