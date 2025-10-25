package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService 
{
    public String getGreeting()
    {
        return "Hello! Welcome to Spring boot + DependencyInjection!";
    } 
    public int add(int a, int b)
    {
        return a+b;
    }
    public int sub(int a,int b)
    {
        return a-b;
    }       
}
