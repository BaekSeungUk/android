package com.bitc.ex6_jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bitc.ex6_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 툴바 추가
        setSupportActionBar(binding.toolbar)

        // 두번째 액티비티(화면)으로 이동
        binding.goTwo.setOnClickListener {
            val intent = Intent(this,TwoActivity::class.java)
            startActivity(intent)
        }

        // 프래그먼트를 적용
        val fragmentManager : FragmentManager = supportFragmentManager
        val transaction : FragmentTransaction = fragmentManager.beginTransaction()
        val fragment = OneFragment()
        transaction.add(R.id.fragmentView, fragment)
        transaction.commit()
    }

    // 메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // 액티비 클래스에서 메뉴생성
//        val menu1: MenuItem? = menu?.add(0,0,0,"두번째 페이지로 이동")
//        val menu2: MenuItem? = menu?.add(0,1,0,"메뉴2")
        
        // 메뉴리소스를 액티비티에 출력
        menuInflater.inflate(R.menu.menu_main,menu)

        // 서치뷰 검색 기능 구현
        val searchMenu = menu?.findItem(R.id.menu3)
        val searchView = searchMenu?.actionView as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("myLog","검색 이벤트 발생 : ${query}")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("myLog","키보드의 입력값에 따라 실시간으로 출력 : ${newText}")
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    // 메뉴 선택시 이벤트 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> {
                Log.d("myLog","0번 메뉴 선택")
                val intent = Intent(this,TwoActivity::class.java)
                startActivity(intent)
            }
            1 -> {
                Log.d("myLog","1번 메뉴 선택")
            }
            R.id.menu1 -> {
                Log.d("myLog","menu1번 선택")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}