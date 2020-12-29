package com.example.phoneauthbyfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.phoneauthbyfirebase.databinding.ActivityLoginBinding
import com.example.phoneauthbyfirebase.databinding.ActivityMainBinding
import com.example.phoneauthbyfirebase.dialog.CustomProgressDialog
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    // 상수 데이터 저장
    companion object {
        private const val TAG = "LoginToFirebaseActivity"
    }

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth
    private val progressDialog = CustomProgressDialog()

    private var isCheckEmail = "이메일 유효성 탈락"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

    
    }




    private fun signIn(email: String, password: String) {
        Log.d(TAG, "signIn:$email")
        // progress dialog 시작
        progressDialog.show(this, "Please Wait...")


        // Firebase 로그인
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                // progress dialog 종료
                progressDialog.dialog.dismiss()

                if (task.isSuccessful) { // 성공시 처리
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "로그인 성공", Toast.LENGTH_SHORT).show()

                    // 신체 정보 입력 화면 이동
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)

                    finish() // 화면 종료

                }
                else { // 실패시 처리
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "이메일 또는 비밀번호가 일치하지 않습니다.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }



}