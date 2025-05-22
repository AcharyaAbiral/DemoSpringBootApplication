package com.example.deliverySystem.mapper;

import com.example.deliverySystem.dto.request.ParcelRequestDTO;
import com.example.deliverySystem.dto.response.ParcelResponseDTO;
import com.example.deliverySystem.entity.Parcel;
import com.example.deliverySystem.entity.User;

public class ParcelMapper {
    public static Parcel mapToParcel(ParcelRequestDTO parcelRequestDTO, User user)
    {
       return Parcel.builder()
               .name(parcelRequestDTO.getName())
               .user(user)
               .category(parcelRequestDTO.getCategory())
               .build();
    }
    public static ParcelResponseDTO mapToParcelResponseDTO(Parcel parcel)
    {
        return ParcelResponseDTO.builder()
                .id(parcel.getId())
                .name(parcel.getName())
                .category(parcel.getCategory())
                .creationTime(parcel.getCreationTime())
                .lastModified(parcel.getLastModified())
                .build();
    }
}
