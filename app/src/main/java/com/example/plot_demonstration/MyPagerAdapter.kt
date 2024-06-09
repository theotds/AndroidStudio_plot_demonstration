package com.example.plot_demonstration

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.plot_demonstration.Fragments.AAChartModelFragment
import com.example.plot_demonstration.Fragments.MPAndroidChartFragment
import com.example.plot_demonstration.Fragments.VicoChartFragment

class MyPagerAdapter(activity: AppCompatActivity, val dataUtil: DataUtil) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MPAndroidChartFragment(dataUtil)
            1 -> AAChartModelFragment(dataUtil)
            2 -> VicoChartFragment(dataUtil)
            else -> throw IllegalStateException("Position $position is invalid for this viewpager")
        }
    }
}