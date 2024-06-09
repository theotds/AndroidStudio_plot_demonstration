package com.example.plot_demonstration.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plot_demonstration.DataUtil
import com.example.plot_demonstration.R
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement


class AAChartModelFragment(val data: DataUtil) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aachart_model, container, false)


        // Setup the first chart for Sales Data
        val aaChartView1 = view.findViewById<AAChartView>(R.id.aaChartView1)
        val aaChartModel1 =
            AAChartModel().chartType(AAChartType.Column).title("Daily Sales").series(
                arrayOf(
                    AASeriesElement().name("Sales").data(data.getDailySalesData().toTypedArray())
                )
            )
        aaChartView1.aa_drawChartWithChartModel(aaChartModel1)

        // Setup the second chart for Temperature Data
        val aaChartView2 = view.findViewById<AAChartView>(R.id.aaChartView2)
        val aaChartModel2 =
            AAChartModel().chartType(AAChartType.Areaspline).title("Daily Temperature").series(
                arrayOf(
                    AASeriesElement().name("Temperature")
                        .data(data.getTemperatureData().toTypedArray())
                )
            )
        aaChartView2.aa_drawChartWithChartModel(aaChartModel2)

        val aaChartView3 = view.findViewById<AAChartView>(R.id.aaChartView3)

        val aaChartModel3 =
            AAChartModel().chartType(AAChartType.Area).title("POPULARITY OF PROGRAMMING LANGUAGE")
                .categories(
                    arrayOf(
                        "Java", "Swift", "Python", "Ruby", "PHP", "Go", "C", "C#", "C++"
                    )
                ).dataLabelsEnabled(false).yAxisGridLineWidth(0f).series(
                    arrayOf(
                        AASeriesElement().name("Tokyo").data(
                            arrayOf(
                                17.0, 16.9, 19.5, 24.5, 28.2, 29.5, 28.2, 26.5, 23.3
                            )
                        ), AASeriesElement().name("NewYork").data(
                            arrayOf(
                                0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1
                            )
                        ), AASeriesElement().name("London").data(
                            arrayOf(
                                0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3
                            )
                        ), AASeriesElement().name("Berlin").data(
                            arrayOf(
                                3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2
                            )
                        )
                    )
                )

        aaChartView3.aa_drawChartWithChartModel(aaChartModel3)

        // Setup the third chart for Radar-like Data
        val aaChartView4 = view.findViewById<AAChartView>(R.id.aaChartView4)
        val aaChartModel4 =
            AAChartModel().chartType(AAChartType.Pie).title("Performance Analysis").series(
                arrayOf(
                    AASeriesElement().name("Elements").data(
                        arrayOf(
                            arrayOf("A", 0.40),
                            arrayOf("B", 0.10),
                            arrayOf("C", 0.20),
                            arrayOf("D", 0.30),

                            )
                    )
                )
            )
        aaChartView4.aa_drawChartWithChartModel(aaChartModel4)

        return view
    }
}