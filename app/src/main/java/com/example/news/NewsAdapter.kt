package com.example.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class NewsAdapter(private val context:Context,private val list: List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
 val titleText:TextView=itemView.findViewById(R.id.titleText)
        val descriptionText:TextView=itemView.findViewById(R.id.descriptionText)
        val imageView:ImageView=itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
     val itemView=LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
     holder.titleText.text=list[position].title

      holder.descriptionText.text=list[position].description
        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.imageView)
        holder.itemView.setOnClickListener {
           val intent=Intent(context,ArticleActivity::class.java)
            intent.putExtra("title",list[position].title)
            intent.putExtra("content",list[position].content)
            context.startActivity(intent)

        }
    }

}