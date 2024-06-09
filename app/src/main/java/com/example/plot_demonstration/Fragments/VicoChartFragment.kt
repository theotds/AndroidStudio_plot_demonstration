package com.example.plot_demonstration.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plot_demonstration.DataUtil
import com.example.plot_demonstration.R
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.views.chart.ChartView

class VicoChartFragment(val data: DataUtil) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vico_chart, container, false)

        // Get the temperature data

        val temperatures = data.getTemperatureData()

        val chartEntryModel = entryModelOf(*temperatures.toTypedArray())

        val chartView = view.findViewById<ChartView>(R.id.chart_view).setModel(chartEntryModel)

        return view
    }
}