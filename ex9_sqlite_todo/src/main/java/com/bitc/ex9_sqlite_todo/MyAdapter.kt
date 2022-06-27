package com.bitc.ex9_sqlite_todo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.ex9_sqlite_todo.databinding.ItemRecyclerviewBinding
import java.lang.Exception

class MyViewHolder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas:MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var db:DBHelper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // 삭제버튼 추가 소스 DB변수 설정
        db = DBHelper(parent.context)
        return MyViewHolder(
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        Log.d("myLog", "리사이클러 뷰 데이터 : ${datas!![position]}")
        binding.itemData.text = datas[position]

        // 삭제 이벤트 추가
        binding.delButton.setOnClickListener {
            Log.d("myLog","${binding.itemData.text}")
            try {
                val data:String = binding.itemData.text.toString()
                val deldb = db.writableDatabase
                deldb.execSQL("delete from TODO_TB where todo = ?", arrayOf(data))
                deldb.close()

                // 삭제후 즉시 갱신
                datas.remove(datas!![position])
                notifyDataSetChanged()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0 // data가 null일때 0을 리턴
    }
}