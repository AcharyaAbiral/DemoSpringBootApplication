package com.example.deliverySystem.service;

import com.example.deliverySystem.dto.LocationRequestDTO;
import com.example.deliverySystem.dto.LocationResponseDTO;
import com.example.deliverySystem.entity.Location;
import com.example.deliverySystem.mapper.LocationMapper;
import com.example.deliverySystem.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<LocationResponseDTO> retrieveAllLocations()
    {
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::mapToLocationResponseDTO)
                .collect(Collectors.toList());
    }

    public LocationResponseDTO insertLocation(LocationRequestDTO locationRequestDTO)
    {
       Location mappedLocation= LocationMapper.mapToLocation(locationRequestDTO);
       return LocationMapper.mapToLocationResponseDTO(locationRepository.save(mappedLocation));
    }
}
