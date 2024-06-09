package com.example.plot_demonstration

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: DataUtil = DataUtil()
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = MyPagerAdapter(this, data)
    }
}