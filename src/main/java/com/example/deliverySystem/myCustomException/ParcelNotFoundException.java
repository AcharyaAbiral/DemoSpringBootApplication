package com.example.deliverySystem.myCustomException;

public class ParcelNotFoundException extends RuntimeException {
    public ParcelNotFoundException(String message) {super(message);}

    public ParcelNotFoundException() {super("Parcel not found");}
}