package com.start.mindcafeclonepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityChattDetailBinding

class ChattDetailActivity : BaseActivity() {

    lateinit var binding: ActivityChattDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_chatt_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutChattDetailActionBar.visibility = View.VISIBLE
        mTxtCahtTile.text = "텍스트"

    }
}