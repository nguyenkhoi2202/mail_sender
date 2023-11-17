package com.example.mailsender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsSenderControler {


    @PostMapping("/send")
    public ResponseEntity<?> sendSms(){


        return ResponseEntity.ok("");
    }
}
