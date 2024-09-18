package com.scheduler.scheduler.config;

import com.scheduler.scheduler.Service.weatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class weatherconfig {

    @Autowired
    private weatherService weatherService;



    // Fetch weather data every minute (60,000 ms)
    @Scheduled(fixedRate = 5000)
    public void fetchWeatherDataScheduled() {
        weatherService.fetchWeatherData();
    }
}
