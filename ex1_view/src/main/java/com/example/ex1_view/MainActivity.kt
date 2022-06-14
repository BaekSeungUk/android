package com.example.ex1_view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ex1_view.databinding.ActivityMainBinding
import com.example.ex1_view.databinding.Ch6ViewBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // textView 생성
        /*val name = TextView(this)
        name.typeface = Typeface.DEFAULT_BOLD // 폰트 굵게
        name.textSize = 30F // 폰트 사이즈
        name.text = "Lake Louis" // 텍스뷰에 들어갈 문자열*/

        // apply 이용하여 textView생성
        // 해당 객체의 속성을 바로 설정 가능하다. (변수.~로 안불러도 된다.)
        val name = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            textSize = 30F
            text = "Lake Louis"
        }

        // imageView 생성
//        val image = ImageView(this)
        // 이미지를 세팅한다. -> R(리소스)안에 있는 리소스 파일을 선택할수 있다.
//        image.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.lake_1))
//        image.adjustViewBounds = true // 이미지의 세로길이에 맞춰서 비율을 맞춰준다

        // also 이용 -> it. 으로 해당 객체를 이용한다.
        val image = ImageView(this).also {
            // 이미지를 가져오는 방법
            // 1. setImageDrawable -> 네트워크나 파일을 읽어서 이미지를 그린다.
            // 2. setImageResource -> res폴더에 있는 리소스를 가져온다.
            it.setImageResource(R.drawable.lake_1)
            it.adjustViewBounds = true
        }


        // textView 생성
        val address = TextView(this)
        address.typeface = Typeface.DEFAULT_BOLD
        address.text = "Lake Louis, AB, 캐나다"

        // 레이아웃을 생성하고, 뷰를 담아준다.
        val layout = LinearLayout(this).apply {
            // 뷰 배치 방향 설정 : orientation
            orientation = LinearLayout.VERTICAL
            // 뷰 정렬 설정 : gravity
            gravity = Gravity.CENTER

            addView(name, WRAP_CONTENT, WRAP_CONTENT)
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(address, WRAP_CONTENT, WRAP_CONTENT)
        }

        // setContentView(출력할 화면) -> 화면출력

        // MainActivity 클래스에서 직접 작성한 뷰를 명시
//        setContentView(layout)

        // res/layout 폴더에 있는 activity_main.xml 명시
//        setContentView(R.layout.activity_main)

        // 뷰 바인딩을 이용하여 화면에 출력
        // 바인딩 객체 획득 : 첫글자와 _ 뒤에오는 글자를 대문자로 만든후 Binding을 붙인다.
        // layoutInflater : XML에 미리 정의해둔 틀을 실제 메모리에 올려주는 역할
        /*val binding = ActivityMainBinding.inflate(layoutInflater)
        // 액티비티 화면에 출력
        setContentView(binding.root)*/

        val binding = Ch6ViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // xml파일에서 지정한 id를 이용해서 뷸를 제어할때 : findViewById()함수를 이용한다.
        // val textView2:TextView = findViewById(R.id.text_lake)
//        val btn1 = findViewById<Button>(R.id.btn1)
//        val btn2 = findViewById<Button>(R.id.btn2)
        // 이벤트 처리 (뷰의 visible 속성 제어)
        /*btn1.setOnClickListener {
            if (btn2.visibility == View.VISIBLE) {
                btn2.visibility = View.INVISIBLE
            } else {
                btn2.visibility = View.VISIBLE
            }
        }*/

        // 바인딩 기법을 이용한 뷰제어
        // binding 아이디 를 이용해서 뷰를 제어할 수 있다. (변수화 하지않아도 된다.)
        /*binding.btn1.setOnClickListener {
            if (binding.btn2.visibility == View.VISIBLE) {
                binding.btn2.visibility = View.INVISIBLE
            } else {
                binding.btn2.visibility = View.VISIBLE
            }
        }*/
    }
}
