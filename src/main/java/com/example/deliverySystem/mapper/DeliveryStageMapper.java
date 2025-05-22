package com.example.deliverySystem.mapper;

import com.example.deliverySystem.dto.response.DeliveryStageDetailsByParcelIdResponseDTO;
import com.example.deliverySystem.dto.request.DeliveryStageRequestDTO;
import com.example.deliverySystem.dto.response.DeliveryStageResponseDTO;
import com.example.deliverySystem.entity.DeliveryStage;
import com.example.deliverySystem.entity.Location;
import com.example.deliverySystem.entity.Parcel;

public class DeliveryStageMapper {
    public static DeliveryStage mapToDeliveryStage(DeliveryStageRequestDTO dto, Parcel parcel, Location sourceLocation,Location destinationLocation)
    {
        return DeliveryStage.builder()
                .parcel(parcel)
                .sourceLocation(sourceLocation)
                .destinationLocation(destinationLocation)
                .deliveryStatus(dto.getStatus())
                .build();
    }
    public static DeliveryStageResponseDTO mapTODeliveryStageResponseDTO(DeliveryStage deliveryStage)
    {
        return DeliveryStageResponseDTO.builder()
                .id(deliveryStage.getId())
                .parcelId(deliveryStage.getParcel().getId())
                .sourceLocationId(deliveryStage.getSourceLocation().getId())
                .destinationLocationId(deliveryStage.getDestinationLocation().getId())
                .deliveryStatus(deliveryStage.getDeliveryStatus())
                .timeStamp(deliveryStage.getTimeStamp())
                .build();
    }

    public static DeliveryStageDetailsByParcelIdResponseDTO mapToDeliveryStageDetailsByParcelIdResponseDTO(DeliveryStage deliveryStage)
    {
       return DeliveryStageDetailsByParcelIdResponseDTO.builder()
               .sourceLocationName(deliveryStage.getSourceLocation().getCountry())
               .destinationLocationName(deliveryStage.getDestinationLocation().getCountry())
               .parcelID(deliveryStage.getParcel().getId())
               .parcelName(deliveryStage.getParcel().getName())
               .timeStamp(deliveryStage.getTimeStamp())
               .id(deliveryStage.getId())
               .destinationLocationContactEmail(deliveryStage.getDestinationLocation().getEmail())
               .status(deliveryStage.getDeliveryStatus())
               .sourceLocationContactEmail(deliveryStage.getSourceLocation().getEmail())
               .build();
    }
}
