package com.example.phoneauthbyfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneauthbyfirebase.databinding.ActivityLoginBinding
import com.example.phoneauthbyfirebase.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

    
    }


}