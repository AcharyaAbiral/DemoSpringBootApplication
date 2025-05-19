package com.example.deliverySystem.CustomException;

import com.example.deliverySystem.entity.Location;

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
