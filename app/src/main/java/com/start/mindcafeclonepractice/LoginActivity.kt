package com.start.mindcafeclonepractice

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.kakao.sdk.user.UserApiClient
import com.start.mindcafeclonepractice.databinding.ActivityLoginBinding
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class LoginActivity : BaseActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnKakaoLogin.setOnClickListener {

            if (UserApiClient.instance.isKakaoTalkLoginAvailable(mContext)) {

//                카톡앱이 깔려 있는 상황
                UserApiClient.instance.loginWithKakaoTalk(mContext){ token, error ->

                    if(error != null){
                        Log.e("카톡로그인","로그인 실패")
                    }
                    else if(token != null){

                        Log.e("카톡로그인","로그인 성공")
                        Log.e("카톡로그인",token.accessToken)
                    }

                }
            }
            else {
//                카톡앱이 깔려있지 않은 상황.
                UserApiClient.instance.loginWithKakaoAccount(mContext){token, error ->
                    if(error != null){
                        Log.e("카톡로그인","로그인 실패")
                    }
                    else if(token != null){

                        Log.e("카톡로그인","로그인 성공")
                        Log.e("카톡로그인",token.accessToken)
                    }
                }
            }
        }

    }


    override fun setValues() {

        keyHash()
    }

    fun keyHash(){

        var packageInfo: PackageInfo? = null
        try{
            packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        if (packageInfo == null) {
            Log.d("hashKey", "null")
        }
        packageInfo?.signatures?.forEach {
            try {
                val md = MessageDigest.getInstance("SHA")
                md.update(it.toByteArray())
                Log.d("hashKey", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
                Log.e("KeyHash", "Unable to get MessageDigest. signature=$it", e)
            }
        }
    }

}