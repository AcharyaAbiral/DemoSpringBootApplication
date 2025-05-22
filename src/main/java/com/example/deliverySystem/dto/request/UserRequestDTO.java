package com.example.deliverySystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message="first name must not be blank")
    @Size(max=255,message="first name must be at most 255 characters")
    private String firstName;

    @NotBlank(message="last name must not be blank")
    @Size(max=255,message="last name must be at most 255 characters")
    private String lastName;

}
