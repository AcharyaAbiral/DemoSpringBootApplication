package com.example.deliverySystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LocationRequestDTO {
    @NotBlank(message="name must not be blank")
    @Size(max=255,message="name must be at most 255 characters")
    private String name;

    @NotBlank(message="email must not be blank")
    @Size(max=255,message="email must be at most 255 characters")
    @Email(message = "invalid email not allowed")
    private String email;
}
