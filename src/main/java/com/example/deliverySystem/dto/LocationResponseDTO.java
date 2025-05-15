package com.example.deliverySystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class LocationResponseDTO {
    private UUID id;
    private String name;
    private String contactEmail;
}
