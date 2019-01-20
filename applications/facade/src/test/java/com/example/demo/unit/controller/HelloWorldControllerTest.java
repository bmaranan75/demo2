package com.example.demo.unit.controller;

import com.example.demo.controller.HelloWorldController;
import com.example.demo.service.GreetingsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
public class HelloWorldControllerTest {

    @InjectMocks
    HelloWorldController helloWorldController;

    @Mock
    GreetingsService service;

    @Test
    public void getGreetingsSuccess() throws Exception {

        String response = "Hello B";
        when(service.getGreetings(anyString())).thenReturn(response);

        Assert.assertEquals(response, helloWorldController.getGreetings("B"));


    }

    @Test
    public void createContactSuccess() throws Exception{

        String status = "Account : BRM createds.";
        String expected = "Account : BRM createds.";

        when(service.createContact(anyString())).thenReturn(Mono.just(status));
        Mono<String> just = helloWorldController.createContact("BRM");
        StepVerifier.create(just).expectNextMatches(resp -> {

            Assert.assertEquals(expected, resp);
            return true;
        }).expectComplete().verify();

    }

}
