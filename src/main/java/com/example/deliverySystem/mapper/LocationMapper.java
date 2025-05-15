package com.example.deliverySystem.mapper;

import com.example.deliverySystem.dto.LocationRequestDTO;
import com.example.deliverySystem.dto.LocationResponseDTO;
import com.example.deliverySystem.entity.Location;

public class LocationMapper {
    public static Location mapToLocation(LocationRequestDTO locationRequestDTO)
    {
        return Location.builder()
                .name(locationRequestDTO.getName())
                .contactEmail(locationRequestDTO.getEmail())
                .build();
    }
    public static LocationResponseDTO mapToLocationResponseDTO(Location location)
    {
        return LocationResponseDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .contactEmail(location.getContactEmail())
                .build();
    }
}
