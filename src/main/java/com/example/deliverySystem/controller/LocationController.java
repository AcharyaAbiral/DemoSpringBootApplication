package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.LocationRequestDTO;
import com.example.deliverySystem.dto.LocationResponseDTO;
import com.example.deliverySystem.entity.Location;
import com.example.deliverySystem.service.LocationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/location")
@RestController
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponseDTO>> retrieveAllLocation()
    {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.retrieveAllLocations());
    }

    @PostMapping
    public ResponseEntity<LocationResponseDTO> insertLocation(@Valid @RequestBody LocationRequestDTO locationRequestDTO)
    {
        LocationResponseDTO location=locationService.insertLocation(locationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(location);
    }
}
