package com.lleans.restapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lleans.restapi.R


class LibararySelector : Fragment(), View.OnClickListener{

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val google = view.findViewById<LinearLayout>(R.id.volley_library)
         val retrofit = view.findViewById<LinearLayout>(R.id.retrofit_library)
        google.setOnClickListener(this)
        retrofit.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_libarary_selector, container, false)
    }

    override fun onClick(v: View) {
        when(v!!.id){
            R.id.volley_library -> navController.navigate(R.id.action_libararySelector_to_volleyActivity)
            R.id.retrofit_library -> navController.navigate(R.id.action_libararySelector_to_retrofit)
        }
    }
}