package com.example.deliverySystem.customException;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException()
    {
        super("Location not found");
    }
    public LocationNotFoundException(String message)
    {
        super(message);
    }
}
