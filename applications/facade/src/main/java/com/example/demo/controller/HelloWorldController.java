package com.example.demo.controller;

import com.example.demo.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private static final String FORMAT = "application/vnd.safeway.v1+json";

    @Autowired
    GreetingsService service;

    @GetMapping(path="/{name}/greetings", produces=FORMAT)
    public String getGreetings(@PathVariable(value = "name") String name){

        return service.getGreetings(name);
    }

    @PostMapping(path = "/{name}/create")
    public Mono<String> createContact(@PathVariable(value="name") String name) {
        return service.createContact(name);
    }
}
