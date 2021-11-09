package com.example.springbootconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${my.greeting1: Displaying defaul value, my.greeting1 does not exist in properties}")
    private String greetingMessage;

    @Value("${my.list.properties}")
    private List<String> myList;

    @Autowired
    public DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting() {
        return ""+dbSettings.getConnection()+" "+dbSettings.getHost()+" "+dbSettings.getPort();
    }
    
}
