package com.bitc.ex10_networking

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bitc.ex10_networking.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get query 요청버튼 클릭시 네트워킹 발생
        binding.getReq.setOnClickListener {

            var userListCall = MyApplication.networkService.doGetUserList("1")
            userListCall.enqueue(object : Callback<UserListModel> {
                override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                    // 통신이 성공했을경우 호출
                    if (response.isSuccessful) {
                        var userList = response.body()
                        Log.d("myLog","네트워킹 성공 : ${userList}")
                    }
                }
                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    // 통신이 실패했을겨우 호출
                    Log.d("myLog","네트워킹 실패")
                }
            })
        }

        binding.getPathReq.setOnClickListener {
            val call:Call<UserModel> = MyApplication.networkService.test2(2)
            call.enqueue(object :Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    Log.d("myLog","test2 네트워킹 성공 : ${response.body()}")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("myLog","test2 네트워킹 실패")
                }

            })
        }

        binding.getQueryMapReq.setOnClickListener {
            val call:Call<UserModel> = MyApplication.networkService.test3(
                mapOf("one" to "hello", "two" to "world"),
                "sik"
            )
            call.enqueue(object : Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    Log.d("myLog","test3 네트워킹 성공")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("myLog","test3 네트워킹 실패")
                }

            })
        }

        binding.glideTest.setOnClickListener {
            Glide.with(this)
                .load("https://reqres.in/img/faces/2-image.jpg")
                .override(500,500)//이미지 크기 조절
                .placeholder(android.R.drawable.stat_notify_call_mute) // 이미지 로딩을 시작하기전에 보여줄 이미지
                .error(android.R.drawable.stat_notify_error) // 리소스를 불러오다가 에러가 발생했을때 보여줄 이미지
                .fallback(android.R.drawable.stat_sys_warning) // 로드할때 url이 null인경우 등 비어있을때 보여줄 이미지
                .into(binding.glideImage)
        }
    }
}

class MyApplication : Application() {
    companion object {
        var networkService: INetworkService
        val retrofit:Retrofit
            get() = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init {
            networkService = retrofit.create(INetworkService::class.java)
        }
    }
}