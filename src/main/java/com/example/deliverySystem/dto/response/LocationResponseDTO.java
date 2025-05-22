package com.example.deliverySystem.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class LocationResponseDTO {
    private UUID id;
    private String country;
    private String city;
    private String street;
    private String email;
    private String phone;
}
