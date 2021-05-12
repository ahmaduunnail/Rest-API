package com.lleans.restapi.intro

import SliderPagerAdapter
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.tabs.TabLayout
import com.lleans.restapi.MainFragmentCanvas
import com.lleans.restapi.R


class Main : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var button: LinearLayout
    lateinit var text: TextView
    lateinit var adapt: SliderPagerAdapter

    fun move_activity(){
        startActivity(Intent(this, MainFragmentCanvas::class.java))
    }

    @StringRes
    private val PAGE_TABS=
        intArrayOf(R.color.yellow, R.color.blue, R.color.purple, R.color.pink)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // making activity full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window // in Activity's onCreate() for instance
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        setContentView(R.layout.activity_main2)
        // hide action bar you can use NoAction theme as well
        // bind views
        viewPager = findViewById(R.id.viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tab)
        button = findViewById(R.id.button)
        text = findViewById(R.id.text_swipe)
        // init slider pager adapter
        adapt = SliderPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        // set adapter
        viewPager?.adapter = adapt
        // set dot indicators
        tabLayout.setupWithViewPager(viewPager)
        // make status bar transparent
        changeStatusBarColor()
        button.setOnClickListener(View.OnClickListener {
            if (viewPager.getCurrentItem() < adapt!!.count) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1)
            }
        })
        /**
         * Add a listener that will be invoked whenever the page changes
         * or is incrementally scrolled
         */
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == adapt!!.count - 1) {
                    text.setText(R.string.praktik)
                    button.setOnClickListener(View.OnClickListener {
                        move_activity()
                    })
                } else {
                    text.setText(R.string.swipe)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}