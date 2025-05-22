package com.example.deliverySystem.myCustomException;

public class LocationNotFoundException extends RuntimeException {
  public LocationNotFoundException(String message) {super(message);}
  public LocationNotFoundException(){super("Location not found");}
}
