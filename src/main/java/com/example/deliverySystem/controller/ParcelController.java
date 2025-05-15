package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.ParcelRequestDTO;
import com.example.deliverySystem.dto.ParcelResponseDTO;
import com.example.deliverySystem.entity.Parcel;
import com.example.deliverySystem.service.ParcelService;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/parcel")
@RestController
@AllArgsConstructor
public class ParcelController {
    private final ParcelService parcelService;

    @GetMapping
    public ResponseEntity<List<ParcelResponseDTO>>retrieveAllParcels()
    {
        List<ParcelResponseDTO> parcelDTOs=parcelService.retrieveAllParcels();
        return ResponseEntity.status(HttpStatus.OK).body(parcelDTOs);
    }

    @PostMapping
    public ResponseEntity<ParcelResponseDTO> insertParcel(@Valid @RequestBody ParcelRequestDTO parcelRequestDTO)
    {
        ParcelResponseDTO parcelResponseDTO=parcelService.insertParcel(parcelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelResponseDTO);
    }

}
