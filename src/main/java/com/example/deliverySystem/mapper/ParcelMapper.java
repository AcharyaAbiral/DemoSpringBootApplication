package com.example.deliverySystem.mapper;

import com.example.deliverySystem.dto.ParcelRequestDTO;
import com.example.deliverySystem.dto.ParcelResponseDTO;
import com.example.deliverySystem.entity.Parcel;

public class ParcelMapper {
    public static Parcel mapToParcel(ParcelRequestDTO parcelRequestDTO)
    {
       return Parcel.builder().
               name(parcelRequestDTO.getName())
               .build();
    }
    public static ParcelResponseDTO mapToParcelResponseDTO(Parcel parcel)
    {
        return ParcelResponseDTO.builder()
                .id(parcel.getId())
                .name(parcel.getName())
                .creationTime(parcel.getCreationTime())
                .lastModified(parcel.getLastModified())
                .build();
    }
}
