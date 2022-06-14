package com.bitc.ex2_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bitc.ex2_layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼을 클릭했을때
        binding.btn.setOnClickListener { 
            binding.btn.visibility = View.INVISIBLE // 버튼은 안보이게
            binding.img.visibility = View.VISIBLE // 이미지는 보이게
        }
        //이미지를 클릭했을때
        binding.img.setOnClickListener { 
            binding.btn.visibility = View.VISIBLE //버튼은 보여지게
            binding.img.visibility = View.INVISIBLE // 이미지는 안보이게
        }
    }
}