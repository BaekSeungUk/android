package com.bitc.ex6_jetpack_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bitc.ex6_jetpack_recycler.databinding.ActivityMainBinding
import com.bitc.ex6_jetpack_recycler.databinding.ActivityRecyclerViewBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        for (i in 1..10) {
            // 원본소스
            datas.add("Item ${i}")

            // StaggeredGridLayout 지그재그 형태로 출력을 위한 데이터 준비
        /*    if (i % 2 == 0) {
                datas.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            } else {
                datas.add("Item ${i}")
            }*/
        }
        adapter = MyAdapter(datas)
        // Linear Layout
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        /*val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL*/

        // Grid Layout
//        val layoutManager = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)

        // StaggeredGridLayout
//        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        /*val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration(this)) // 데코레이션 적용*/
        
        //viewPage2 적용 : 리사이클러 뷰 어댑터 이용
//        binding.viewPage.adapter = adapter
        
        // viewPager2 적용 : 프래그먼트 어댑터 이용
        binding.viewPage.adapter = MyFragmentPagerAdapter(this)

        //drawer 메뉴 토글 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        // 새로운 아이템 추가
      /*  binding.addItem.setOnClickListener {
            adapter.addItem()
        }*/
        // 아이템 삭제
       /* binding.removeItem.setOnClickListener {
            adapter.removeItem()
        }*/
    }

    // 메뉴에서 항목 선택시 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) { // 토글버튼 클릭시 이벤트 추가
            Log.d("myLog","토클 버튼 이벤트")
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}