package com.example.deliverySystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {
    private UUID id;
    private String firstName;
    private String lastName;
}
