package com.example.phoneauthbyfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneauthbyfirebase.databinding.ActivityPhoneAuthBinding
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneAuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneAuthBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        /**
        구현해야하는 전화번호 화면이었습니다.
        처음에는 인증번호 입력 칸이 disabled 되어 있고,
        휴대폰번호 입력 후 인증요청을 하면 성공적으로 전화번호 인증코드 수신이 완료되면,
        인증번호 입력칸이 abled 되어서 칠 수 있게 했습니다.
         */

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)


    }




}