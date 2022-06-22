package com.example.ex8_component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ex8_component.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //extra데이터 받기
        val intent = intent
        val exData1 = intent.getStringExtra("myData1")
        val exData2 = intent.getIntExtra("myData2",0)
        Log.d("myLog","exData1 : ${exData1} , exData2 : ${exData2}")

        binding.gohome.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            intent.putExtra("resultData","결과값")
            setResult(RESULT_OK,intent)
            finish()
        }


    }
}



