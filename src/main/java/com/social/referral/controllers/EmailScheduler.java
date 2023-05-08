package com.social.referral.controllers;
import com.social.referral.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@EnableScheduling
public class EmailScheduler {
    @Autowired
    EmailService emailService;
    @Scheduled(fixedDelay = 20000)
    public void sendMail() {
        emailService.sendEmail();

    }
}
