package com.example.deliverySystem.dto.response;

import com.example.deliverySystem.utils.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class DeliveryStageDetailsByParcelIdResponseDTO {
    private UUID id;
    private String sourceLocationName;
    private String sourceLocationContactEmail;
    private String destinationLocationName;
    private String destinationLocationContactEmail;
    private String parcelName;
    private UUID parcelID;
    private LocalDateTime timeStamp;
    private Status status;
}
