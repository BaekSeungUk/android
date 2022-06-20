package com.bitc.ex6_jetpack_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bitc.ex6_jetpack_recycler.databinding.ActivityMainBinding
import com.bitc.ex6_jetpack_recycler.databinding.ActivityRecyclerViewBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
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
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        // Grid Layout
//        val layoutManager = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)

        // StaggeredGridLayout
//        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        // 새로운 아이템 추가
        binding.addItem.setOnClickListener {
            adapter.addItem()
        }
        // 아이템 삭제
        binding.removeItem.setOnClickListener {
            adapter.removeItem()
        }
    }
}