package com.start.mindcafeclonepractice

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kakao.sdk.user.UserApiClient
import com.start.mindcafeclonepractice.databinding.ActivityLoginBinding
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class LoginActivity : BaseActivity() {

    lateinit var binding : ActivityLoginBinding

//  기본로그인에서 사용할 FirebaseAuth
    private var auth: FirebaseAuth? = null

//    firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth
//    google Client
    private lateinit var googleSignClient: GoogleSignInClient

//    priveat const val TAG = "GoogleActivity"
    private val RC_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        setupEvents()
        setValues()

        auth = Firebase.auth


//       Google 로그인 옵션 구성. requestToken 및 Email 요청.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("463327764022-lcd4qt3vomn9189alis6derig5p0f72a.apps.googleusercontent.com")
            //"R.string.default_web_client_id"에는 본인의 클라이언트 아이디를 넣어주면 됨.
            //스트링을 따로 빼서 사용하지 않고 지금처름 통째로 넣어도 됨.
            .requestEmail()
            .build()

        googleSignClient = GoogleSignIn.getClient(mContext, gso)

        //firebase auth객체
        firebaseAuth = FirebaseAuth.getInstance()
    }
    //onStart. 유저가 앱에 이미 구글 로그인이 되어있는지 확인, 자동로그인
//    override fun onStart() {
//        super.onStart()
//        val account = GoogleSignIn.getLastSignedInAccount(mContext)
//        if (account != null){
//            //이미 로그인 되어있다면 바로 메인 액티비티로 이동
//            toMainActivity(firebaseAuth.currentUser!!)
//        }
//    } //onStart End

    //로그아웃 하지 않을시 자동로그인, 회원가입시 바로 로그인됨.
//    public override fun onStart() {
//        super.onStart()
//
//        moveMainPage(auth?.currentUser)
//    }

    //onActivityResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    //Google Sign In was successful. authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogle(account!!)
                    Log.d("구글토큰",account.idToken.toString())
                }catch (e: ApiException){
                    //Google Sign In failed, updata UI appropriately
                    Log.w("LoginActivity","Google sign in failed",e)
                }
        }

    } //onActivityResult End

      //firebaseAuthWithGoogle
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount){
        Log.d("LoginActivity","firebaseAuthWithGoogle" + acct.id!!)

          //Google SignAccount 객체에서 ID 토큰을 가져와서 Firebase Auth로 교환하고 Firebase에 인증
          val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
          firebaseAuth.signInWithCredential(credential)
              .addOnCompleteListener(this) { task->
                  if (task.isSuccessful){
                      Log.d("LoginActivity","firebaseAuthWithGoogle 성공", task.exception)
                      toMainActivity(firebaseAuth.currentUser!!)
                  } else {
                      Log.d("LoginActivity","firebaseAuthWithGoogle 실패", task.exception)
                      Toast.makeText(mContext, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                  }

              }
    } //firebaseAuthWithGoogle End

    //firebaseActivity
    fun toMainActivity(user: FirebaseUser){
        if (user != null) {
            startActivity(Intent(mContext, MainActivity::class.java))

            Toast.makeText(mContext, "구글로그인 하셨습니다. ${firebaseAuth.currentUser!!.displayName}님 환영합니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    } //toMainActivity End

    //signIn
    private fun siginIn(){
        val signInIntent = googleSignClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    //signIn End


    private fun signOut(){
        //Firebase sign out
        firebaseAuth.signOut()

        //Google sign out
        googleSignClient.signOut().addOnCompleteListener(this) {
            //updateUI(null)
        }
    }

    //회원탈퇴
    private fun revokeAccess(){
        //Firebase sign out
        firebaseAuth.signOut()
        googleSignClient.revokeAccess().addOnCompleteListener(this) {

        }
    }

    override fun setupEvents() {

//        기본로그인 버튼 눌리면
        binding.btnLogin.setOnClickListener {

            val inputId = binding.edtId.text.toString()
            val inputPw = binding.edtPw.text.toString()

            signIn(inputId, inputPw)

        }

        binding.btnSignUp.setOnClickListener {

            startActivity(Intent(mContext, SignUpActivity::class.java))


        }

//      카카오 로그인 버튼 눌리면
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

                        getMyInfoFromKakao()
                        startActivity(Intent(mContext,LoginActivity::class.java))

                        finish()
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

                        getMyInfoFromKakao()

                        startActivity(Intent(mContext,LoginActivity::class.java))

                        finish()
                    }
                }
            }
        }

        //        구글 로그인 버튼
        binding.btnGoogleLogin.setOnClickListener {
            siginIn()


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

    fun getMyInfoFromKakao(){
        UserApiClient.instance.me { user, error ->

            if (error != null) {
                Log.d("카톡로그인", "사용자 정보 요청 실패", error)
            }
            else if ( user != null) {
                Log.i("카톡로그인","사용자 정보 요청 성공" + "\n회원정보 : ${user.id}" +
                                                                "\n이메일 : ${user.kakaoAccount?.email}" +
                                                                "\n닉네임 : ${user.kakaoAccount?.profile?.nickname}")
            }
        }
    }

    fun signIn(email: String, password: String){

        if(email.isNotEmpty() && password.isNotEmpty()){
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if(task.isSuccessful){
                        Toast.makeText(mContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                        moveMainPage(auth?.currentUser)
                    }else{
                        Toast.makeText(mContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    //유저정보 넘겨주고 메인 액티비티 호출
    fun moveMainPage(user: FirebaseUser?){
        if(user!= null){
            startActivity(Intent(mContext,MainActivity::class.java))
            finish()
        }
    }


}