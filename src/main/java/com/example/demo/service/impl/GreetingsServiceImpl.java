package com.example.demo.service.impl;

import com.example.demo.service.GreetingsService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String getGreetings(String name) {
        return "Hello " + name;
    }

    @Override
    public Mono<String> createContact(String name){
        return  Mono.just("Account : " + name  + " created.");
    }
}
