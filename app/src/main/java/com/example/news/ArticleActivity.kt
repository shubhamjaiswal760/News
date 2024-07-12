package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val title=intent.getStringExtra("title")
        val content=intent.getStringExtra("content")
        val articleTitle:TextView=findViewById(R.id.articleTitle)
        val articleContent:TextView=findViewById(R.id.articleContent)
        articleTitle.text=title
        articleContent.text=content

    }
}