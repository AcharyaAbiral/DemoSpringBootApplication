package com.example.deliverySystem.customException;

public class ParcelNotFoundException extends RuntimeException{
    public ParcelNotFoundException()
    {
        super("Parcel not found");
    }
    public ParcelNotFoundException(String message)
    {
        super(message);
    }
}
