package com.lleans.restapi.volley

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.lleans.restapi.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class VolleyActivity : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<HeroAdapter.ViewHolder>
    private var heroList: List<HeroModel> = ArrayList()
    private val url = "https://api.opendota.com"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycle_volley)
        getvolley()
    }

    //method getVolley
    private fun getvolley() {
        val stringRequest = StringRequest(
            Request.Method.GET, url +
                    "/api/herostats",
            { response -> response?.let { getData(it) } }
        ) { Toast.makeText(context, "Error Data", Toast.LENGTH_LONG).show() }
        val requestQueue: RequestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }

    //method getData
    private fun getData(request: String) {
        try {
            val jsonArray = JSONArray(request)
            for (i in 0..10) {
                val data: JSONObject = jsonArray.getJSONObject(i)
                var att: String = data.getString("primary_attr")
                when (att) {
                    "int" -> att = "Intelegent"
                    "str" -> att = "Strength"
                    "agi" -> att = "Agility"
                }
                val hero = HeroModel(
                    data.getString("localized_name"),
                    att,
                    data.getString("attack_type"),
                    url + data.getString("img"),
                    url + data.getString("img")
                )
                heroList = listOf(hero)
                adapter = HeroAdapter(heroList)
                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }
        } catch (e: JSONException) { //untuk menangkap kesalahan
            Toast.makeText(context, "Error Data", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volley_activity, container, false)
    }

}