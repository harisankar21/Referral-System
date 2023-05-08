package com.social.referral.services;
import com.social.referral.entities.ReferralRequest;
import com.social.referral.entities.User;
import com.social.referral.repository.ReferralRequestRepository;
import com.social.referral.repository.UserRepository;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import java.nio.file.*;
import java.util.*;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    ReferralRequestRepository referralRepo;


    @Autowired
    UserRepository userRepo;

    public void sendEmail() {


        String recipients = new String();
        List<ReferralRequest> referralRequests = referralRepo.findAllNonApprovedReferralRequests();

        Map<String, Integer> userRequestMap = new HashMap();
        for (ReferralRequest request : referralRequests) {
            User user = userRepo.findById(request.getTakenBy().getId()).orElse(new User());
            userRequestMap.put(user.getEmail(), request.getId());
        }
        for (Map.Entry<String, Integer> mapElement : userRequestMap.entrySet()) {
            {
                try {
                    MimeMessage mailMessage = javaMailSender.createMimeMessage();
                    mailMessage.setFrom(Environment.getProperties().getProperty("spring.mail.username"));
                    mailMessage.setRecipients(MimeMessage.RecipientType.TO, mapElement.getKey());
                    mailMessage.setSubject("Approval Notification");
                    mailMessage.setContent(new String(Files.readAllBytes(Paths.get("C:\\Users\\albgeorge\\Downloads\\Referral-System\\src\\main\\resources\\template\\ApprovalNotificationTemplate.html"))), "text/html; charset=utf-8");
                    javaMailSender.send(mailMessage);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }


        }
    }

}
