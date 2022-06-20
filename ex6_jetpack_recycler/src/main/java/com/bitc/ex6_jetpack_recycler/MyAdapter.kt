package com.bitc.ex6_jetpack_recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.ex6_jetpack_recycler.databinding.ActivityRecyclerViewBinding

// 뷰홀더
class MyViewHolder (val binding :ActivityRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)

// 어댑터
class MyAdapter(var datas:MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 항목의 뷰를 가지는 뷰 홀더를 준비
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            ActivityRecyclerViewBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    // 뷰 홀더의 뷰에 데이터를 출력
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        Log.d("myLog","${datas[position]}")
        binding.itemData.text = datas[position]
    }

    // 항목의 갯수를 판단
    override fun getItemCount(): Int {
        return datas.size
    }

    fun addItem(){
        datas.add("new Item${datas.size+1}")
        notifyDataSetChanged()
    }
    fun removeItem(){
        // 아이템 삭제 1번
        /*if (datas.size > 0) {
            datas.removeAt(datas.size-1)
            notifyDataSetChanged()
        }else {
            //토스트 메세지 출력해서 사용자에게 메세지를 줄수도 있다.
        }*/
        // 아이템 삭제 2번
        datas.removeLastOrNull()
        notifyDataSetChanged()
        if (datas.size == 0) {
            //토스트 메세지 출력해서 사용자에게 메세지를 줄수도 있다.
        }
    }
}