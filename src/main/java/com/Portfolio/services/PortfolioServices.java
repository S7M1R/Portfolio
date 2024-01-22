package com.Portfolio.services;

import com.Portfolio.payload.EmailBody;
import com.Portfolio.util.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PortfolioServices {
    @Autowired
    private EmailServices emailServices;


    public void sendEmailToS7M1R(EmailBody emailbody) {
        EmailBody emailbody1 = new EmailBody();
        emailbody1.setSenderEmail(emailbody.getSenderEmail());
        emailbody1.setMessage(emailbody.getMessage());
        emailbody1.setSenderName(emailbody.getSenderName());


        emailServices.sendMailServices(emailbody1);
    }


    public ResponseEntity<byte[]> DownloadCVRequest() throws Exception{
        ClassPathResource pdfFile = new ClassPathResource("static/files/Resume.pdf");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Resume.pdf");

        Path path = Paths.get(pdfFile.getURI());
        byte[] pdfBytes = Files.readAllBytes(path);

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
}
