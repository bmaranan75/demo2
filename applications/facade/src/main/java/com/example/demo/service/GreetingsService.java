package com.example.demo.service;

import reactor.core.publisher.Mono;

public interface GreetingsService {
    public String getGreetings(String name);
    public Mono<String> createContact(String name);
}
