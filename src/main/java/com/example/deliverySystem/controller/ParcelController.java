package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.request.ParcelRequestDTO;
import com.example.deliverySystem.dto.response.ParcelResponseDTO;
import com.example.deliverySystem.myCustomException.UserNotFoundException;
import com.example.deliverySystem.service.ParcelService;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@RequestMapping("/parcel")
@RestController
@AllArgsConstructor
public class ParcelController {
    private final ParcelService parcelService;

    @GetMapping
    public ResponseEntity<List<ParcelResponseDTO>>retrieveAllParcels(@RequestBody ParcelRequestDTO dto)
    {
        if(dto.getUserId()==null)
        {
            throw new UserNotFoundException("userId: userId must not be blank");
        }
        List<ParcelResponseDTO> parcelResponseDTOS=parcelService.retrieveAllParcels(dto);
        return ResponseEntity.status(HttpStatus.OK).body(parcelResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<ParcelResponseDTO> insertParcel(@Valid @RequestBody ParcelRequestDTO parcelRequestDTO)
    {
        ParcelResponseDTO parcelResponseDTO=parcelService.insertParcel(parcelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelResponseDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<?>> searchUsingParameters(@RequestBody ParcelRequestDTO dto)
    {
        if(dto.getUserId()==null)
        {
            throw new UserNotFoundException("userId: userId not provided");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parcelService.searchParcel(dto));
    }

    @GetMapping("/details")
    public ResponseEntity<List<ParcelResponseDTO>> retrieveParcelDetails( @Valid @RequestBody ParcelRequestDTO dto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(parcelService.retrieveParcelDetails(dto));
    }

}
