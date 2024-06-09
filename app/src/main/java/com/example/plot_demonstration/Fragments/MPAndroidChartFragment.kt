package com.example.plot_demonstration.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plot_demonstration.DataUtil
import com.example.plot_demonstration.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class MPAndroidChartFragment(val data: DataUtil) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mpandroid_chart, container, false)

        // Initialize the BarChart for Daily Sales
        val barChart = view.findViewById<BarChart>(R.id.barChart)
        val dailySalesData = data.getDailySalesData().mapIndexed { index, value ->
            BarEntry(index.toFloat(), value.toFloat())
        }
        val barDataSet = BarDataSet(dailySalesData, "Daily Sales")
        barDataSet.color = Color.BLUE
        val barData = BarData(barDataSet)
        barChart.data = barData
        barChart.invalidate() // Refresh the chart

        // Initialize the LineChart for Temperature
        val lineChart1 = view.findViewById<LineChart>(R.id.lineChart1)
        val temperatureData = data.getTemperatureData().mapIndexed { index, value ->
            Entry(index.toFloat(), value.toFloat())
        }
        val lineDataSet1 = LineDataSet(temperatureData, "Daily Temperature")
        lineDataSet1.color = Color.RED
        val lineData1 = LineData(lineDataSet1)
        lineChart1.data = lineData1
        lineChart1.invalidate() // Refresh the chart

        // Initialize the LineChart for Daily Revenue
        val lineChart2 = view.findViewById<LineChart>(R.id.lineChart2)
        val dailyRevenueData = data.getDailyRevenueData().mapIndexed { index, value ->
            Entry(index.toFloat(), value.toFloat())
        }
        val lineDataSet2 = LineDataSet(dailyRevenueData, "Daily Revenue")
        lineDataSet2.color = Color.BLACK
        lineDataSet2.setCircleColor(Color.BLACK)
        lineDataSet2.valueTextColor = Color.BLACK
        lineDataSet2.lineWidth = 2f
        lineDataSet2.circleRadius = 5f
        lineDataSet2.setDrawFilled(true)
        val lineData2 = LineData(lineDataSet2)
        lineChart2.data = lineData2


        lineChart2.invalidate() // Refresh the chart

        val radarChart = view.findViewById<RadarChart>(R.id.radarChart)
        val entries = listOf(
            RadarEntry(120f),
            RadarEntry(150f),
            RadarEntry(180f),
            RadarEntry(90f),
            RadarEntry(110f),
            RadarEntry(130f),
            RadarEntry(170f)
        )

        val radarDataSet = RadarDataSet(entries, "Performance")
        radarDataSet.color = Color.RED
        radarDataSet.fillColor = Color.BLUE
        radarDataSet.setDrawFilled(true)
        radarDataSet.lineWidth = 2f

        val radarData = RadarData(radarDataSet)
        radarChart.data = radarData

        radarChart.description.isEnabled = false

        // Style the radar chart
        val xAxis = radarChart.xAxis
        xAxis.textSize = 9f
        xAxis.yOffset = 0f
        xAxis.xOffset = 0f
        xAxis.valueFormatter = IndexAxisValueFormatter(listOf("Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G"))

        val yAxis = radarChart.yAxis
        yAxis.setLabelCount(6, true)
        yAxis.textSize = 9f
        yAxis.setDrawLabels(false)

        radarChart.invalidate() // Refresh the chart


        return view
    }
}