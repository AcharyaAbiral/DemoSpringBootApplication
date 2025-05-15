package com.example.deliverySystem.dto;

import com.example.deliverySystem.entity.Location;
import com.example.deliverySystem.entity.Parcel;
import com.example.deliverySystem.utils.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class DeliveryStageResponseDTO {
    private UUID id;
    private UUID parcelId;
    private UUID sourceLocationId;
    private UUID destinationLocationId;
    private Status deliveryStatus;
    private LocalDateTime timeStamp;
}
