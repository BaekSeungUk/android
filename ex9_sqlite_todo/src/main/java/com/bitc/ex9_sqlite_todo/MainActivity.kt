package com.bitc.ex9_sqlite_todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.ex9_sqlite_todo.databinding.ActivityMainBinding
import com.bitc.ex9_sqlite_todo.databinding.ItemRecyclerviewBinding

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

        // 할일목록을 addACtivity에서 가져오는 부분
  /*      datas = savedInstanceState?.let {
            // 번들객체(savedInstanceState)에 데이터가 있을때
            it.getStringArrayList("datas")?.toMutableList()
        }?: let {
            // 번들객체(savedInstanceState)에 데이터가 null 일때
            mutableListOf<String>()
        }*/
        datas = mutableListOf()

        // DB에서 데이터를 가져온다
        val db = DBHelper(this).writableDatabase
        val cursor = db.rawQuery("select * from TODO_TB",null)
        cursor.run {
            while (moveToNext()) {
                Log.d("myLog","할일 목록 : ${cursor.getString(1)}")
                datas?.add(cursor.getString(1))
            }
        }
        db.close()

        // 리사이클러뷰 화면 구성
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerview.layoutManager = layoutManager
        adapter = MyAdapter(datas!!)
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }

}