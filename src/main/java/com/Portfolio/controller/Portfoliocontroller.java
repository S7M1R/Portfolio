package com.Portfolio.controller;

import com.Portfolio.payload.EmailBody;
import com.Portfolio.services.PortfolioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Controller
public class Portfoliocontroller {

    @Autowired
    private PortfolioServices portfolioServices;

    @RequestMapping("/")
    public String indexPage() {
        return "index.html";
    }

    @RequestMapping("/home")
    public String indexPage2() {
        return "index.html";
    }

    @RequestMapping("/redirectToLinkedin")
    public String redirectToLinkedin() {
        return "http://www.linkedin.com/in/sameeroddin-kazi";
    }

    @GetMapping("/downloadCV")
    public ResponseEntity<byte[]> downloadPdf() throws IOException {
        ResponseEntity<byte[]> responseEntity;
        try {
            responseEntity = portfolioServices.DownloadCVRequest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return responseEntity;
    }

    @PostMapping("/sendEmail")
    public String getFormData(
            @RequestParam("Name") String name,
            @RequestParam("Email") String email,
            @RequestParam("Message") String message) {
        EmailBody emailBody = new EmailBody();
        emailBody.setSenderName(name);
        emailBody.setSenderEmail(email);
        emailBody.setMessage(message);
        portfolioServices.sendEmailToS7M1R(emailBody);
        return "redirect:/home";
    }

}
