package com.example.plot_demonstration

class DataUtil {
    val temperatures: List<Float> = setTemperatureData()
    val sales: List<Float> = setDailySalesData()
    val revenue: List<Float> = setDailyRevenueData()

     fun getTemperatureData(): List<Float> {
        return temperatures
    }

     fun getDailySalesData(): List<Float> {
        return sales
    }

     fun getDailyRevenueData(): List<Float> {
        return revenue
    }


    private fun setTemperatureData(): List<Float> {
        return List(7) { 20f + (Math.random() * 15).toFloat() }
    }

    private fun setDailySalesData(): List<Float> {
        return List(30) { (50 + Math.random() * 50).toFloat() }  // Random sales between 50 and 100 items per day
    }

    private fun setDailyRevenueData(): List<Float> {
        return List(30) { (1000.0 + Math.random() * 500.0).toFloat() }  // Random revenue between $1000 and $1500 per day
    }
}
