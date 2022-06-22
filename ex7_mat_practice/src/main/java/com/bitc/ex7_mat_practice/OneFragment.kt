package com.bitc.ex7_mat_practice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.ex7_mat_practice.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOneBinding.inflate(inflater, container, false)

        val datas = mutableListOf<String>()
        for (i in 1..20) {
            datas.add("item${i}")
        }

        // context를 매개변수로 넣을 때 AppCompatActivity를 상속받는 페이지에서는 this 키워드로 이용
        // 그렇지않으면 activity를 매개변수로 넣어준다.
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerview.layoutManager=layoutManager
        val adapter = MyAdapter(datas)
        binding.recyclerview.adapter=adapter
        binding.recyclerview.addItemDecoration(MyAdapter.MyDecoration(activity as Context))

        return binding.root
    }
}