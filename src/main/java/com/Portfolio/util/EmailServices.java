package com.Portfolio.util;

import com.Portfolio.payload.EmailBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServices {

    @Autowired
    private JavaMailSender javaMailSender;

    private int count = 1;

    public void sendMailServices(EmailBody emailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        count++;
        message.setTo("contact.sameeroddinkazi@gmail.com");
        message.setSubject("Response Email from Portfolio ResponseNo : "+getCount());
        message.setText("Senders Name: " + emailBody.getSenderName() + "\nSenders Email: " + emailBody.getSenderEmail() + "\nMessage: " + emailBody.getMessage());
        javaMailSender.send(message);
    }

    public int getCount() {
        return count;
    }

}
