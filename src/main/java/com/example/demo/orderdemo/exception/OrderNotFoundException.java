package com.example.demo.orderdemo.exception;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {

  public OrderNotFoundException(Long orderId) {
    super("Could not find order " + orderId);
  }
}