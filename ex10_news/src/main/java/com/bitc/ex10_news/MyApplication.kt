package com.bitc.ex10_news

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication:Application() {
    companion object {
        val API_KEY = "a8f0d4f98b2f4e60847d990ca71a8503"
        val BASE_URL = "https://newsapi.org"

        // 네트워크 서비스
        var networkService: NetworkService
        val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())// 데이터 컨버팅을 위한 세팅
            .build()
        init {
            // 인터페이스에 네트워킹이 가능하도록 생성
            networkService = retrofit.create(NetworkService::class.java)
        }
    }
}