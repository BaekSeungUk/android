package com.bitc.ex4_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.ex4_practice.databinding.ActivityMain2Binding
import com.bitc.ex4_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}