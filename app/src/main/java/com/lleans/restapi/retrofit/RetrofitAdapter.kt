package com.lleans.restapi.retrofit

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lleans.restapi.R
import com.lleans.restapi.retrofit.RetrofitAdapter.NewsViewHolder


class RetrofitAdapter(
    private val title: List<String>,
    private val desc: List<String>,
    private val author: List<String>,
    private val images: List<String>,
    private val url: List<String>
) :
    RecyclerView.Adapter<NewsViewHolder>() {
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title_tv: TextView = itemView.findViewById(R.id.news_title)
        val desc_tv: TextView = itemView.findViewById(R.id.news_desc)
        val author_tv: TextView = itemView.findViewById(R.id.news_author)
        val img_photo_img: ImageView = itemView.findViewById(R.id.img_news)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url[position])
                startActivity(itemView.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RetrofitAdapter.NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_card, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title_tv.text = title[position]
        holder.desc_tv.text = desc[position]
        holder.author_tv.text = author[position]
        Glide.with(holder.img_photo_img)
            .load(images[position])
            .into(holder.img_photo_img)
    }

    override fun getItemCount(): Int = title.size
}