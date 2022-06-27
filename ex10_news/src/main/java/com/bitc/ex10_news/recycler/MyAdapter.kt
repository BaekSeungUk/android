package com.bitc.ex10_news.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.ex10_news.databinding.ItemMainBinding
import com.bitc.ex10_news.model.ItemModel
import com.bumptech.glide.Glide

class MyViewHolder(val binding:ItemMainBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val context: Context, val datas:MutableList<ItemModel>?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        val model = datas!![position]
        binding.itemTitle.text = model.title
        binding.itemDesc.text = model.description
        binding.itemTime.text = "${model.author} At ${model.publishedAt}"
        // 이미지뷰에 이미지추가
        Glide.with(context)
            .load(model.urlToImage) // 서버로부터 받은 이미지url의 문자열
            .into(binding.itemImage) // 받은 이미지를 itemImage에 출력
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }
}