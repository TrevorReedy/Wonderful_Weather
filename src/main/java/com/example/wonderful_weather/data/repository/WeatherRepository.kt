package com.example.wonderful_weather.data.repository

import com.example.wonderful_weather.data.api.WeatherApiService
import com.example.wonderful_weather.data.model.WeatherResponse

class WeatherRepository(private val weatherApiService: WeatherApiService) {
    suspend fun getWeatherData(lat: Double, lon: Double, apiKey: String): WeatherResponse {
        return weatherApiService.getWeatherData(lat, lon, apiKey)
    }
}

