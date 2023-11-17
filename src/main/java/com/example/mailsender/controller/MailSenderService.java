package com.example.mailsender.controller;

import com.example.mailsender.Request;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;

@RestController
@RequestMapping("api/mail")
public class MailSenderService {

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/send")
    public ResponseEntity<?> send (@RequestBody Request request) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String[] listMailTo = new String[0];
        String[] listMailCc = new String[0];
        if (request.getTo() != null && !request.getCc().isEmpty() && request.getTo().contains(",")){
            listMailTo = request.getTo().split(",");
        }
        if (request.getCc() != null && !request.getCc().isEmpty() && request.getTo().contains(",")){
            listMailCc = request.getCc().split(",");
        }

        if (listMailTo.length >0){
            helper.setTo(listMailTo);
        }
        if (listMailCc.length >0){
            helper.setCc(listMailCc);
        }


        helper.setSubject(request.getSubject());
        helper.setText(request.getBody());

        javaMailSender.send(message);

        return ResponseEntity.ok("Gửi thành công đến " + request.getTo() + "," + request.getCc()

        );
    }
}
