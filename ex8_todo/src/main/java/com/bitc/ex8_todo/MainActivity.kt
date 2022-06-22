package com.bitc.ex8_todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.ex8_todo.databinding.ActivityMainBinding
import com.bitc.ex8_todo.databinding.ItemRecyclerviewBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ItemRecyclerviewBinding
    var datas:MutableList<String>? = null
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // requestLauncher 생성
        var requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            it.data!!.getStringExtra("result")?.let {
                datas?.add(it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.mainFab.setOnClickListener{
            // addActivity로 인텐트에 담아서 시스템에 전달
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        datas = savedInstanceState?.let {
            // 번들객체(savedInstanceState)에 데이터가 있을때
            it.getStringArrayList("datas")?.toMutableList()
        }?: let {
            // 번들객체(savedInstanceState)에 데이터가 null 일때
            mutableListOf<String>()
        }

        // 리사이클러뷰 화면 구성
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerview.layoutManager = layoutManager
        adapter = MyAdapter(datas!!)
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("datas", ArrayList(datas))
    }
}