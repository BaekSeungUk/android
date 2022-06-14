package com.example.ex1_kakaologin_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex1_kakaologin_page.databinding.ActivityMainBinding
import com.example.ex1_kakaologin_page.databinding.Ch6ViewBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // 뷰바인딩 기법을 이용해서 화면을 출력 해봅시다.
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        val binding = Ch6ViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}