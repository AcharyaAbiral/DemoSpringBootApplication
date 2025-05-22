package com.example.deliverySystem.myCustomException;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {super(message);}

  public UserNotFoundException() {super("user not found");}
}
