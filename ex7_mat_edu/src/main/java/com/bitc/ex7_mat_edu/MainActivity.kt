package com.bitc.ex7_mat_edu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bitc.ex7_mat_edu.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 소스코드에서 탭 버튼 정의
       /* val tabLayout = binding.tabs
        val tab1 : TabLayout.Tab = tabLayout.newTab()
        tab1.text="tab1"
        tabLayout.addTab(tab1)
        val tab2 : TabLayout.Tab = tabLayout.newTab()
        tab2.text="tab2"
        tabLayout.addTab(tab2)
        val tab3 : TabLayout.Tab = tabLayout.newTab()
        tab3.text="tab3"
        tabLayout.addTab(tab3)*/

        val tabLayout = binding.tabs
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            // 탭 버튼을 선택할때 이벤트
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.text) {
                    "tab1" -> Log.d("myLog","tab1번 선택")
                    "tab2" -> Log.d("myLog","tab2번 선택")
                    "tab3" -> Log.d("myLog","tab3번 선택")
                }
            }
            // 다른탭 버튼을 눌러 선택된 탭버튼이 해제될때 이벤트
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("myLog","선택된 탭 버튼이 해제될때")
            }
            // 선택된 탭 버튼을 다시 선택할때 이벤트
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("myLog","선택된 탭 버튼 다시 선택")
            }
        })

        // Drawable 레이아웃 메뉴에 이벤트 추가
        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("myLog","네비게이션 아이템 클릭 : ${it.title}")
            true
        }

        // 플로팅 액션버튼 모양변경
        binding.extendedFab.setOnClickListener {
            when (binding.extendedFab.isExtended) { // 아이콘과 문자열 둘다 표시 했다면
                true -> binding.extendedFab.shrink()
                false -> binding.extendedFab.extend()
            }
        }
    }
}