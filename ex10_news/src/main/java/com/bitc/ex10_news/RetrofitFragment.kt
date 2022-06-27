package com.bitc.ex10_news

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitc.ex10_news.databinding.FragmentRetrofitBinding
import com.bitc.ex10_news.model.PageListModel
import com.bitc.ex10_news.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_retrofit, container, false)
        val binding = FragmentRetrofitBinding.inflate(inflater,container,false)
        var category:String? = this.arguments?.get("category").toString()

        if (category == "null") {
            category = null
        }

        val call: Call<PageListModel> = MyApplication.networkService.getList(
            MyApplication.API_KEY,
            "kr",
            category
        )

        call.enqueue(object : Callback<PageListModel>{
            override fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {
                binding.retrofitRecyclerView.layoutManager = LinearLayoutManager(activity)
                binding.retrofitRecyclerView.adapter = MyAdapter(activity as Context, response.body()?.articles)
            }

            override fun onFailure(call: Call<PageListModel>, t: Throwable) {
                Log.d("myLog", "error 입니다.")
            }

        })
        return binding.root
    }

}