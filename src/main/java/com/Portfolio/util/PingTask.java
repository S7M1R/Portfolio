package com.Portfolio.util;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PingTask {

    private final String firstWebsiteUrl = "https://sameeroddinkazi.onrender.com";
    private final RestTemplate restTemplate;

    public PingTask(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Scheduled every 2 minutes, 24 hours a day, 7 days a week
    @Scheduled(cron = "0 */2 * * * *")
    public void pingFirstWebsite() {
        restTemplate.getForObject(firstWebsiteUrl, String.class);
        restTemplate.getForObject(firstWebsiteUrl, String.class);
        System.out.println("Pinging portfolio to prevent inactivity...");
    }
}
