package com.start.mindcafeclonepractice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.start.mindcafeclonepractice.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {

    lateinit var binding: ActivitySignUpBinding

    //  기본로그인에서 사용할 FirebaseAuth
    private var auth : FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        setupEvents()
        setValues()
        auth = Firebase.auth
    }

    override fun setupEvents() {

        binding.btnSignUpOk.setOnClickListener{
            val inputEmail = binding.edtId.text.toString()
            val inputPw = binding.edtPw.text.toString()

            createAccount(inputEmail, inputPw)
        }

    }

    override fun setValues() {

    }

    fun createAccount(email: String, password: String){

        if(email.isNotEmpty() && password.isNotEmpty()){
            auth?.createUserWithEmailAndPassword(email,password)
                ?.addOnCompleteListener(this) {task ->
                    if (task.isSuccessful) {
                        Toast.makeText(mContext, "가입을 축하드립니다.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(mContext, MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(mContext, "계정생성 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}