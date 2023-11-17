package com.example.mailsender;

import jdk.jfr.DataAmount;
import org.springframework.util.StringUtils;

public class Request {
    private String to;

    private String cc;
    private String subject;
    private String body;

    public Request() {
    }

    public Request(String to, String cc, String subject, String body) {
        this.to = to;
        this.cc = cc;
        this.subject = subject;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
