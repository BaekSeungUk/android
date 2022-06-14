package com.bitc.ex4_resource_edu

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowMetrics
import androidx.core.content.res.ResourcesCompat
import com.bitc.ex4_resource_edu.databinding.ActivityMain2Binding
import com.bitc.ex4_resource_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        //ActivityMain2Binding : activity_main2.xml을 클래스화 한 것
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // R파일에서 리소스 사용(소스코드에서 사용시)
        // R.폴더명(id).value(name) 형태로 리소스를 사용한다.

        //소스코드에서 리소스 사용하기
        /*binding.textView.text = getString(R.string.my_string)
        binding.textView.setTextColor(ResourcesCompat.getColor(resources, R.color.myColor, null))*/
        
        // 화면 크기정보를 확인
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            //30버전(코드 R, 안드로이드 11) 부터는 WindowMetrics를 이용
            val windowMetrics : WindowMetrics = windowManager.currentWindowMetrics
            Log.d("myLog","30버전 이후 화면 크기 확인" +
            "width : ${windowMetrics.bounds.width()} , " +
            "height : ${windowMetrics.bounds.height()}")
        }else {
            //30버전 이전에는 DisplayMetrics를 이용
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display.getRealMetrics(displayMetrics)
            Log.d("myLog","30버전 이전 화면 크기 확인 : " +
                    "width : ${displayMetrics.widthPixels} , " +
                    "height : ${displayMetrics.heightPixels}")
        }
    }
}