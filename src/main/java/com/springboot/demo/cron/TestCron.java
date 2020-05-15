package com.springboot.demo.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author aloofJr
 * @date 2019/4/7
 */
@Component
public class TestCron {
    @Scheduled(cron = "*/10 * * * * ?")
    public void echo() {
        System.out.println("this" + System.currentTimeMillis());
    }
}
