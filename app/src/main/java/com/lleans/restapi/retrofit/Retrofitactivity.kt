package com.lleans.restapi.retrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lleans.restapi.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Retrofitactivity : Fragment() {


    private var title_list = mutableListOf<String>()
    private var desc_list = mutableListOf<String>()
    private var author_list = mutableListOf<String>()
    private var url_list = mutableListOf<String>()
    private var img_list = mutableListOf<String>()

    private val BASE_URL = "https://newsapi.org/v2/"
    lateinit var recycler_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getArticle()
                for (article in response.articles) {
                    addList(
                        article.title,
                        article.description,
                        article.urlToImage,
                        article.url,
                        article.author
                    )
                }
                withContext(Dispatchers.Main) {
                    recycler_view = view.findViewById(R.id.recycle_retrofit)
                    recycler_view.layoutManager = LinearLayoutManager(context)
                    recycler_view.adapter =
                        RetrofitAdapter(title_list, desc_list, author_list, img_list, url_list)
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Error Data", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addList(title: String, desc: String, img: String, link: String, author: String) {
        title_list.add(title)
        desc_list.add(desc)
        img_list.add(img)
        author_list.add(author)
        url_list.add(link)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrofit, container, false)
    }
}