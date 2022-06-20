package com.bitc.ex6_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bitc.ex6_jetpack.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_two)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 업 버튼(뒤로가기)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    // 업버튼 클릭시 자동으로 호출되는 함수 재정의
    override fun onSupportNavigateUp(): Boolean {
        Log.d("myLog","업 버튼 클릭시에 자동으로 호출")
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}