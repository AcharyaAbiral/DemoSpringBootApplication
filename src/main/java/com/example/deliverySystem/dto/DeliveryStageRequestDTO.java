package com.example.deliverySystem.dto;

import com.example.deliverySystem.utils.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryStageRequestDTO {
    @NotNull(message = "parcel_id must not be null")
    private UUID parcelId;

    @NotNull(message="source_location_id must not be null")
    private UUID sourceLocationId;

    @NotNull(message="destination_location_id must not be null")
    private UUID destinationLocationId;

    @NotNull(message="status must not be blank")
    private Status status;

}
