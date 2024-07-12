package com.example.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {
    private val retrofit=Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory((GsonConverterFactory.create()))
        .build()


    val newsInstance: Newsinterface= retrofit.create(Newsinterface::class.java)


}
