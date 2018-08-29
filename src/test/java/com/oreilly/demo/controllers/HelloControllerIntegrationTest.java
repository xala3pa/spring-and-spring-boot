package com.oreilly.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.is;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void should_say_hello_without_name() throws Exception {
    mvc.perform(
      get("/hello").accept(MediaType.TEXT_PLAIN))
      .andExpect(status().isOk())
      .andExpect(view().name("hello"))
      .andExpect(model().attribute("user",is("world")));
  }

  @Test
  public void should_say_hello_with_name() throws Exception {
    mvc.perform(
      get("/hello").param("name", "Alvaro").accept(MediaType.TEXT_PLAIN))
      .andExpect(status().isOk())
      .andExpect(view().name("hello"))
      .andExpect(model().attribute("user",is("Alvaro")));
  }
}