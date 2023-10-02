package com.example.englearn.data.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @GET("как-pisat-stixi/vvodnaya-lekciya/")
    @Headers("Accept: text/html")
    fun getArticle(): Call<String>
}