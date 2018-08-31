package com.oreilly.demo.controllers;

import static org.junit.Assert.*;

import com.oreilly.demo.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void should_greeting_without_name() {
    ResponseEntity<Greeting> greetMessage = restTemplate.getForEntity("/rest", Greeting.class);
    assertEquals(HttpStatus.OK, greetMessage.getStatusCode());
    assertEquals(MediaType.APPLICATION_JSON_UTF8, greetMessage.getHeaders().getContentType());
    Greeting response = greetMessage.getBody();
    assertEquals("Hello, World!", response.getGreeting());
  }

  @Test
  public void should_greeting_with_name() throws Exception {
    Greeting greetMessage = restTemplate.getForObject("/rest?name=Alvaro", Greeting.class);
    assertEquals("Hello, Alvaro!", greetMessage.getGreeting());
  }
}