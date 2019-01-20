package com.example.demo.unit.service;

import com.example.demo.service.impl.GreetingsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
public class GreetingsServiceTest {

    @InjectMocks
    GreetingsServiceImpl service;

    @Test
    public void getGreetingsSuccess() throws Exception {
        String expected = "Hello B";
        String response = service.getGreetings("B");

        Assert.assertEquals(expected, response);

    }

    @Test
    public void getGreetingsFailed() throws Exception {
        String expected = "Hello C";
        String response = service.getGreetings("B");

        Assert.assertNotEquals(expected, response);

    }

    @Test
    public void createContactSuccess() throws Exception{

        String expectedResponse = "Account : BRM created.";
        Mono<String> just = service.createContact("BRM");
        StepVerifier.create(just).expectNextMatches(resp -> {
           String response = expectedResponse;
           Assert.assertEquals(resp, expectedResponse);
           return true;
        }).expectComplete().verify();
    }

}

