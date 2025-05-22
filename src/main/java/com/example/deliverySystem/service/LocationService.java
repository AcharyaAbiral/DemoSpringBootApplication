package com.example.deliverySystem.service;

import com.example.deliverySystem.dto.request.LocationInsertionRequestDTO;
import com.example.deliverySystem.dto.response.LocationResponseDTO;
import com.example.deliverySystem.dto.request.LocationSearchRequestDTO;
import com.example.deliverySystem.entity.Location;
import com.example.deliverySystem.mapper.LocationMapper;
import com.example.deliverySystem.myCustomException.LocationNotFoundException;
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

    public List<?> searchLocation(LocationSearchRequestDTO dto)
    {
        if(dto.getCountry()==null)
        {
            return locationRepository.findByCountryInitials("");
        }
        if(dto.getCity()==null)
        {
            return locationRepository.findByCountryInitials(dto.getCountry().toLowerCase());
        }
        else if(dto.getStreet()==null)
        {
            return locationRepository.findByCityInitials(dto.getCountry().toLowerCase(),dto.getCity().toLowerCase());
        }
        else
        {
            return locationRepository.findByStreetInitials(dto.getCountry().toLowerCase(),dto.getCity().toLowerCase(),dto.getStreet().toLowerCase());
        }
    }

    public LocationResponseDTO retrieveLocationDetails(LocationSearchRequestDTO dto)
    {
        Location location=locationRepository.findLocationDetails(dto.getCountry().toLowerCase(),dto.getCity().toLowerCase(),dto.getStreet().toLowerCase());
        if(location==null)
        {
            throw new LocationNotFoundException("location does not exist");
        }
        return LocationMapper.mapToLocationResponseDTO(location);
    }

    public LocationResponseDTO insertLocation(LocationInsertionRequestDTO locationRequestDTO)
    {
        //set fields to lowercase
       locationRequestDTO.setCountry(locationRequestDTO.getCountry().toLowerCase());
       locationRequestDTO.setCity(locationRequestDTO.getCity().toLowerCase());
       locationRequestDTO.setStreet(locationRequestDTO.getStreet().toLowerCase());

       //map dto to Location
       Location mappedLocation= LocationMapper.mapToLocation(locationRequestDTO);

       //save and return response dto after mapping
       return LocationMapper.mapToLocationResponseDTO(locationRepository.save(mappedLocation));
    }
}
