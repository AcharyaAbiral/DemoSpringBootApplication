package com.example.deliverySystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ParcelResponseDTO {
    private UUID id;
    private String name;
    private LocalDateTime creationTime;
    private LocalDateTime lastModified;
}
