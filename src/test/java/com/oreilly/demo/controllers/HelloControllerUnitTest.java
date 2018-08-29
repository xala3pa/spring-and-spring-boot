package com.oreilly.demo.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class HelloControllerUnitTest {

  @Test
  public void should_say_hello() {
    //given
    HelloController helloController = new HelloController();
    //and
    Model model = new BindingAwareModelMap();
    //when
    String message = helloController.sayHello("World", model);
    //then
    assertEquals("World", model.asMap().get("user"));
    assertEquals("hello", message);
  }
}