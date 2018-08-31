package com.oreilly.demo.entities;

public class Greeting {

  private String greeting;

  public String getGreeting() {
    return greeting;
  }

  public Greeting() {
  }

  public Greeting(String greeting) {
    this.greeting = greeting;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Greeting)) {
      return false;
    }

    Greeting greeting1 = (Greeting) o;

    return getGreeting() != null ? getGreeting().equals(greeting1.getGreeting())
      : greeting1.getGreeting() == null;
  }

  @Override
  public int hashCode() {
    return getGreeting() != null ? getGreeting().hashCode() : 0;
  }

  @Override
  public String
  toString() {
    return greeting;
  }
}
