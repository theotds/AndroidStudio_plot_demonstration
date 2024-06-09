package com.example.plot_demonstration.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plot_demonstration.DataUtil
import com.example.plot_demonstration.R
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.core.marker.Marker
import com.patrykandpatrick.vico.views.chart.ChartView

class VicoChartFragment(val data: DataUtil) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vico_chart, container, false)


        val salesData = data.getDailySalesData()
        val barChartEntryModel = entryModelOf(*salesData.toTypedArray())
        val chartViewBar = view.findViewById<ChartView>(R.id.chartViewBar)
        chartViewBar.setModel(barChartEntryModel)


        val temperatureData = data.getTemperatureData()
        val lineChartEntryModel = entryModelOf(*temperatureData.toTypedArray())
        val chartViewLine = view.findViewById<ChartView>(R.id.chartViewLine)
        chartViewLine.setModel(lineChartEntryModel)


        val revenueData = data.getDailyRevenueData()
        val line2ChartEntryModel = entryModelOf(*revenueData.toTypedArray())
        val chartViewWeb = view.findViewById<ChartView>(R.id.chartline2)
        chartViewWeb.setModel(line2ChartEntryModel)


        return view
    }
}