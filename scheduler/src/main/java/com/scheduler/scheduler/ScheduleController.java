package com.scheduler.scheduler;

import com.scheduler.scheduler.config.schedulerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ScheduleController {


     @Autowired
    private schedulerConfig schedulerConfig;

      @GetMapping("/tasks")
     public String task(){
          schedulerConfig.scheduleTask();
          return "scheduler performing task";

     }
    @GetMapping("/tasks1")
    public String tas1k(){
        schedulerConfig.scheduleTask1();
        return "scheduler performing task1";

    }

}
