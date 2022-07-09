package com.start.mindcafeclonepractice

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.start.mindcafeclonepractice.databinding.ActivityQandAactivityBinding
import com.start.mindcafeclonepractice.databinding.ActivityQuestionAndAnswerBinding

class QuestionAndAnswerActivity : BaseActivity() {

    lateinit var binding: ActivityQuestionAndAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_question_and_answer)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mLinearLayoutMainActionBar.visibility = View.GONE
        mLinearLayoutQandAActionBar.visibility = View.VISIBLE

    }
}