package com.scheduler.scheduler.controller;

import com.scheduler.scheduler.Service.weatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class weatherController {

    @Autowired
    private weatherService weatherService;

    @GetMapping("/latest-weather")
    public String getLatestWeather() {
        return weatherService.getLatestWeatherData();
    }

    @GetMapping("/trigger-weather-fetch")
    public String triggerWeatherFetch() {
        weatherService.fetchWeatherData();
        return "Weather data fetched manually!";
    }
}
