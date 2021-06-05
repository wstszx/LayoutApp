package com.example.layoutapp.service

import com.blankj.utilcode.util.SPUtils
import com.example.layoutapp.bean.Plan
import com.example.layoutapp.bean.Station
import com.example.layoutapp.bean.Task
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //通过日期获取任务列表
    @GET("/TaskOrder")
    fun getTaskByDate(
        @Query("date") date: String,
    ): Call<ArrayList<Task>>

    //    通过id获取任务列表
    @GET("/TaskOrder")
    fun getTaskById(
        @Query("min_id") min_id: String,
    ): Call<ArrayList<Task>>

    //    获取指定计划
    @GET("/PlanLayout")
    fun getPlan(
        @Query("id") planId: String,
    ): Call<ArrayList<Plan>?>


    //    获取站位信息
    @GET("/Station")
    suspend fun getStation(
        @Query("stano") stano: String?,
    ): Station

    companion object {
        fun create(): ApiService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

//            val urlStr = SPUtils.getInstance().getString("url", "http://192.168.101.137:8087")
            val urlStr = SPUtils.getInstance().getString("url", "http://www.wstszx.com")
            return Retrofit.Builder()
                .baseUrl(urlStr)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ApiService::class.java)
        }
    }
}