package com.appsuki.app.data.remote


import com.appsuki.app.data.model.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/native/japanese")
    fun listNews() : Call<NewsList>

    @GET("/native/japanese")
    fun detailNews(@Query("url") url: String) : Call<NewsList>

    @GET("/native/japanese")
    fun searchNews(@Query("q") url: String) : Call<NewsList>
}