package com.bitc.ex10_networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface INetworkService {
    @GET("api/users")
    fun doGetUserList(
        @Query("page") page: String
    ): Call<UserListModel>
    // 최종 요청 url : https://reqres.in/api/users?page=1

    @GET("api/users/{id}")
    fun test2(
        @Path("id") userId: Int,
    ): Call<UserModel>
    // 최종 요청 url : https://reqres.in/api/users/2

    @GET("group/users")
    fun test3(
        @QueryMap options: Map<String,String>,
        @Query("name") name: String
    ): Call<UserModel>
    // 최종 요청 url : https://reqres.in/group/users?one=hello&two=world&name=sik
}