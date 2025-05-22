package com.example.deliverySystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ParcelRequestDTO {
    @NotBlank(message = "Name must not be blank")
    @Size(max = 255, message = "Name must be at most 255 characters")
    private String name;

    @NotBlank(message="category must not be blank")
    @Size(max=255,message="category must be at most 255 characters")
    private String category;

    @NotNull(message="user id must not be null")
    private UUID userId;
}
