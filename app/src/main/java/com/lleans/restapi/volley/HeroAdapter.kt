package com.lleans.restapi.volley

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestOptions
import com.lleans.restapi.R

class HeroAdapter(var heroList: List<HeroModel>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    lateinit var url: String

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.news_card, null)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = heroList[position]
        holder.mNama.text = hero.heroName
        holder.mAttribute.text = hero.heroAttr
        holder.mAttack.text = hero.heroAttack
        url = hero.heroUrl
        try {
            Glide.with(holder.itemView).load(hero.heroImg).apply( RequestOptions().override(800, 200)).into(holder.mImg)
        } catch (e: GlideException) {
            holder.mImg.setImageResource(R.drawable.google__g__logo_svg)
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mNama: TextView = itemView.findViewById(R.id.news_title)
        var mAttribute: TextView = itemView.findViewById(R.id.news_desc)
        var mAttack: TextView = itemView.findViewById(R.id.news_author)
        var mImg: ImageView = itemView.findViewById(R.id.img_news)

        init {
            itemView.setOnClickListener { v: View ->
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
    }
}