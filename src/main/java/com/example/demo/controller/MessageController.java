package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")

public class MessageController {
    @GetMapping
    public String getMessage(){
        return "Hello from Spring Boot!";
    }

    @PostMapping
    public String postMessage(@RequestBody String message){
        return "Received message : "+message;
    }
}
