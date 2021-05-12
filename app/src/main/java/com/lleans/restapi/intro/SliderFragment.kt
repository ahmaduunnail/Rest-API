package com.lleans.restapi.intro

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.lleans.restapi.R


class SliderFragment : Fragment(){

    private val ARG_POSITION: String = "slider-position"

    @StringRes
    private val PAGE_TITLES =
        intArrayOf(R.string.restapi_title, R.string.retrofit_title, R.string.volley_title, R.string.praktik_title)

    @StringRes
    private val DESC_TITLES =
        intArrayOf(R.string.restapi_desc, R.string.retrofit_desc, R.string.volley_desc, R.string.pratik_desc)

    @StringRes
    private val PAGE_IMAGES_MAIN =
        intArrayOf(R.drawable.page_2_2, R.drawable.page_3_2, R.drawable.page_4_2, R.drawable.page_5_2)

    @StringRes
    private val PAGE_IMAGES_SECONDARY=
        intArrayOf(R.drawable.page_2_1, R.drawable.page_3_1, R.drawable.page_4_1, R.drawable.page_5_1)

    private var position: Int = 0

    fun SliderItemFragment() {
        // Required empty public constructor
    }

    fun newInstance(position: Int): SliderFragment {
        val fragment = SliderFragment()
        val args = Bundle()
        args.putInt(ARG_POSITION, position)
        fragment.setArguments(args)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            position = arguments!!.getInt(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.itemslider, container, false)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set page background
        val title: TextView = view.findViewById(R.id.title_slider)
        val desc: TextView = view.findViewById(R.id.desc_slider)
        val imageMain: ImageView = view.findViewById(R.id.img_slider)
        val imageSecondary: ImageView = view.findViewById(R.id.bottom_slider_img)
        // set page title
        title.setText(PAGE_TITLES[position])
        // set page sub title text
        desc.setText(DESC_TITLES[position])
        // set page image
        imageMain.setImageResource(PAGE_IMAGES_MAIN[position])
        imageSecondary.setImageResource(PAGE_IMAGES_SECONDARY[position])
    }
}
