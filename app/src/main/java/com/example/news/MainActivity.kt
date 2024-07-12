package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
          getNews()
    }
    private fun getNews(){
        val news =NewsService.newsInstance.fetchHeadlines("in",Constants.API_KEY)
        news.enqueue(object : Callback<News>{
            override fun onFailure(p0: Call<News>, p1: Throwable) {
                println(p1.message)

            }

            override fun onResponse(p0: Call<News>, p1: Response<News>) {
                val newsResponse= p1.body()
                newsResponse?.let {
                    recyclerView.adapter = NewsAdapter(this@MainActivity, newsResponse.articles)
                }
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                }



        })
    }
}