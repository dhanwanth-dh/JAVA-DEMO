package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
public class HelloController 
{
    private final HelloService helloService;
    //Constructor based Dependency injection
    public HelloController(HelloService helloService)
    {
        this.helloService=helloService;
    }    
    /*@GetMapping("/hello")
    public String sayHello()
    {
        return helloService.getGreeting();
    }*/

    /*@GetMapping("/add")
    public int addnum(@RequestParam int a, @RequestParam int b)
    {
        return helloService.add(a,b);
    }*/

    @GetMapping("/sub")
    public int subnum(@RequestParam int a,@RequestParam int b)
    {
        return helloService.sub(a,b);
    }

}
