package com.example.deliverySystem.mapper;

import com.example.deliverySystem.dto.request.LocationInsertionRequestDTO;
import com.example.deliverySystem.dto.response.LocationResponseDTO;
import com.example.deliverySystem.entity.Location;

public class LocationMapper {
    public static Location mapToLocation(LocationInsertionRequestDTO locationRequestDTO)
    {
        return Location.builder()
                .country(locationRequestDTO.getCountry())
                .city(locationRequestDTO.getCity())
                .street(locationRequestDTO.getStreet())
                .email(locationRequestDTO.getEmail())
                .phone(locationRequestDTO.getPhone())
                .build();
    }
    public static LocationResponseDTO mapToLocationResponseDTO(Location location)
    {
        return LocationResponseDTO.builder()
                .id(location.getId())
                .country(location.getCountry())
                .city(location.getCity())
                .street(location.getStreet())
                .email(location.getEmail())
                .phone(location.getPhone())
                .build();
    }
}
