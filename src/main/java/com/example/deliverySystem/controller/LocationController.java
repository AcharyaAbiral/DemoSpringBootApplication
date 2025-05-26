package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.request.LocationInsertionRequestDTO;
import com.example.deliverySystem.dto.response.LocationResponseDTO;
import com.example.deliverySystem.dto.request.LocationSearchRequestDTO;
import com.example.deliverySystem.service.LocationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequestMapping("/location")
@RestController
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponseDTO>> retrieveAllLocations()
    {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.retrieveAllLocations());
    }

    @GetMapping("/search")
    public ResponseEntity<List<?>> searchUsingParameters(@RequestBody LocationSearchRequestDTO dto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.searchLocation(dto));
    }

    @GetMapping("/details")
    public ResponseEntity<LocationResponseDTO> retrieveLocationDetails(@Valid @RequestBody LocationSearchRequestDTO requestDTO)
    {
        LocationResponseDTO responseDTO=locationService.retrieveLocationDetails(requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PostMapping
    public ResponseEntity<LocationResponseDTO> insertLocation(@Valid @RequestBody LocationInsertionRequestDTO locationRequestDTO)
    {
        LocationResponseDTO location=locationService.insertLocation(locationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(location);
    }
}
