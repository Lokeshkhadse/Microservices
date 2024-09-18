package com.scheduler.scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class schedulerConfig {


   @Scheduled(fixedRate = 5000)
    public void scheduleTask(){
        System.out.println("scheduled task " + System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduleTask1(){
        System.out.println("scheduled task1 " + new Date());
    }
}