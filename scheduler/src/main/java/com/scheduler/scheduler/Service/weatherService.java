package com.scheduler.scheduler.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class weatherService {

    private String latestWeatherData = "No data yet";

    public void fetchWeatherData() {

        // Simulating API call with a random temperature
        String weatherData = "Temperature: " + Math.round(20 + Math.random() * 10) + " °C, Fetched at: " + LocalDateTime.now();
        latestWeatherData = weatherData;
        System.out.println("Weather Data Updated: " + weatherData);
    }

    public String getLatestWeatherData() {
        return latestWeatherData;
    }
}
