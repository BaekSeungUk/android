package com.bitc.ex3_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.bitc.ex3_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //터치 이벤트
    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Log.d("myLog","터치 이벤트 발생")

        // 터치 이벤트 좌표값 얻기 : MotionEvent 객체로 획득
        // x : 이벤트가 발생한 뷰의 x좌표
        // y : 이벤트가 발생한 뷰의 y좌표
//        Log.d("myLog","x의 좌표값 : ${event?.x} , y의 좌표값 : ${event?.y}")
        // 터치 이벤트의 종류
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> { //클릭을 한상태
                Log.d("myLog", "ACTION_DOWN")
            }
            MotionEvent.ACTION_UP -> { //마우스에서 손가락을 뗀순간
                Log.d("myLog", "ACTION_UP")
            }
            MotionEvent.ACTION_MOVE -> { //드래그 할때
                Log.d("myLog", "ACTION_MOVE")
            }
        }
        return super.onTouchEvent(event)
    }


    // 키 이벤트 (소프트키보드가 아님)
    // 뒤로가기 버튼, 볼륨 버튼
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        Log.d("myLog","키가 눌렸을때 발생")
//        return super.onKeyDown(keyCode, event)
//    }
    // keyCode값으로 어떤 키가 눌렸는지 식별
//    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
//        Log.d("myLog","키를 눌렀다 뗐을때 발생 : ${keyCode}")
//        when(keyCode){
//            KeyEvent.KEYCODE_VOLUME_DOWN ->{
//                Log.d("myLog","볼륨 다운버튼 클릭")
//            }
//            KeyEvent.KEYCODE_VOLUME_UP ->{
//                Log.d("myLog","볼륨 업버튼 클릭")
//            }
//        }
//        return super.onKeyUp(keyCode, event)
//    }
    // 뒤로가기 버튼 이벤트 함수2
    override fun onBackPressed() {
        Log.d("myLog", "뒤로가기 버튼 클릭")
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1.액티비티에서 인터페이스 구현
        binding.btn1.setOnClickListener(this)

        // 2. 별도의 핸들러 구현
        binding.btn2.setOnClickListener(Handler())

        // 3. SAM기법
        binding.btn3.setOnClickListener {
            Log.d("myLog","btn3번 클릭")
        }

        // 롱 클릭 이벤트
        binding.btn3.setOnLongClickListener {
            Log.d("myLog", "btn3번 길게 클릭")
            true
        }

        //좋아요 버튼 만들어보기 - 이벤트 처리
        binding.heart2.setOnClickListener {
            // 빈하트를 클릭하면 -> 하트는 보여지고 빈하트는 안보여짐
            binding.heart2.visibility = View.INVISIBLE
            binding.heart1.visibility = View.VISIBLE
        }
        binding.heart1.setOnClickListener {
            // 하트를 클릭하면 -> 빈하트는 보여지고 하트는 안보여짐
            binding.heart2.visibility = View.VISIBLE
            binding.heart1.visibility = View.INVISIBLE

        }
    }
    // 1.액티비티에서 인터페이스 구현
    override fun onClick(v: View?) {
        Log.d("myLog","btn1번 클릭")
    }
}

// 2. 별도의 핸들러 구현
class Handler: View.OnClickListener{
    override fun onClick(v: View?) {
        Log.d("myLog","btn2번 클릭")
    }

}