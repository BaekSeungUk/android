package com.bitc.ex6_jetpack_recycler

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
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

        // 리사이클러 뷰 어댑터 이용 뷰페이저2 구현
        when (position % 3) {
            0 -> binding.itemData.setBackgroundColor(Color.RED)
            1 -> binding.itemData.setBackgroundColor(Color.BLUE)
            2 -> binding.itemData.setBackgroundColor(Color.GREEN)
        }
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

class MyDecoration (val context: Context): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.back),0f,0f,null)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        // 뷰 크기 계산
        val width = parent.width
        val height = parent.height
        // 이미지 크기 계산
        val dr: Drawable? = ResourcesCompat.getDrawable(context.getResources(),R.drawable.kbo,null)
        val drWidth = dr?.intrinsicWidth
        val drHeight = dr?.intrinsicHeight
        // 이미지가 그려질 위치 계산
        val left = width / 2 - drWidth?.div(2) as Int
        val top = height /2 - drHeight?.div(2) as Int
        c.drawBitmap(
            BitmapFactory.decodeResource(context.getResources(), R.drawable.kbo),
            left.toFloat(),
            top.toFloat(),
            null
        )

    }

    // 개별 항목 꾸미기
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1
        if (index % 3 == 0) {
            outRect.set(10,10,10,60)
        } else {
            outRect.set(10,10,10,0)
            view.setBackgroundColor(Color.LTGRAY)
            ViewCompat.setElevation(view, 20.0f)
        }
    }
}