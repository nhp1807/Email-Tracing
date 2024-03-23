package com.example.emailtracing.tracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;

@Controller
@RequestMapping("/api/v1/email-tracing")
public class ApplicationController {
    @GetMapping("/email-list/{userId}/{campainId}")
    public HttpResponse<String> getMailOfUser() {
        return null;
    }
}
