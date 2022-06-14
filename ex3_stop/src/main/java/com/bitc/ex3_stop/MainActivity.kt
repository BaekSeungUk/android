package com.bitc.ex3_stop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.bitc.ex3_stop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 스탑워치를 멈춘시간
    var pauseTime = 0L
    // 뒤로가기버튼의 시간 계산용
    var initTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //스탑워치 기능 구현
        //시작버튼
        binding.startButton.setOnClickListener {
            // 스탑워치 시간 = 부팅부터 현재까지 시간 + 멈춘시간
            // SystemClock.elapsedRealtime() : 부팅된 시점부터 현재까지의 시간을 millisecond로 리턴
            binding.chronometer.base = SystemClock.elapsedRealtime()+pauseTime
            binding.chronometer.start()
            //버튼의 표시 조정
            binding.startButton.isEnabled = false
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
        }
        //스탑버튼
        binding.stopButton.setOnClickListener {
            // 멈춘시간 = 스탑워치 시간 - SystemClock.elapsedRealtime()
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            //버튼의 표시 조정
            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
        }
        //리셋버튼
        binding.resetButton.setOnClickListener {
            // 멈춘 시간 초기화
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            //버튼의 표시 조정
            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 뒤로가기 버튼을 눌렀을때
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //뒤로가기 버튼을 처음 눌렀거나, 누른지 3초가 지난후에 다시 눌렀을때
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this,"종료하려면 한번 더 누르세요!",Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}