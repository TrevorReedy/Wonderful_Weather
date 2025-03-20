package com.example.wonderful_weather
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.wonderful_weather.data.api.RetrofitInstance
import com.example.wonderful_weather.data.repository.WeatherRepository
import com.example.wonderful_weather.ui.screen.WeatherScreen
import com.example.wonderful_weather.ui.screen.WeatherViewModel
import com.example.wonderful_weather.ui.theme.Wonderful_WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = WeatherRepository(RetrofitInstance.weatherApiService)
        val viewModel = WeatherViewModel(repository)

        // Hardcoded latitude and longitude (replace with actual values)
        val lat =  36.17 // Example: San Francisco latitude
        val lon = -115.13 // Example: Las Vegas
        val apiKey : String = BuildConfig.WEATHER_API_KEY //REPLACE WITH YOUR API KEY AS A STRING

        // Fetch weather data
        viewModel.fetchWeather(lat, lon, apiKey)

        // Set the UI
        setContent {
            Wonderful_WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherScreen(viewModel = viewModel)
                }
            }
        }
    }
}