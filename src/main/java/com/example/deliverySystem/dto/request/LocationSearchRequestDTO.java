package com.example.deliverySystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LocationSearchRequestDTO {
    @NotBlank(message="country must not be blank")
    @Size(max=255,message="country must be at most 255 characters")
    private String country;

    @NotBlank(message="city must not be blank")
    @Size(max=255,message="city must be at most 255 characters")
    private String city;

    @NotBlank(message="street must not be blank")
    @Size(max=255,message="street must be at most 255 characters")
    private String street;

}
