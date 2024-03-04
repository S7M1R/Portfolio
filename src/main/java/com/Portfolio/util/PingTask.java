package com.Portfolio.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PingTask {

    private final String WebsiteUrl = "https://sameeroddinkazi.onrender.com";

    private final RestTemplate restTemplate;

    public PingTask(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0 */29 6-23,0-2 * * *") // Scheduled every 29 minutes from 6 am to 2 am, 7 days a week
    public void pingWebsite() {
        System.out.println("Pinging website to prevent inactivity...");
        restTemplate.getForObject(WebsiteUrl, String.class);
    }
}
