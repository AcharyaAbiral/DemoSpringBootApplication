package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.DeliveryStageDetailsByParcelIdResponseDTO;
import com.example.deliverySystem.dto.DeliveryStageRequestDTO;
import com.example.deliverySystem.dto.DeliveryStageResponseDTO;
import com.example.deliverySystem.entity.DeliveryStage;
import com.example.deliverySystem.service.DeliveryStageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/delivery-stage")
@RestController
@AllArgsConstructor
public class DeliveryStageController {
    private final DeliveryStageService deliveryStageService;

    @GetMapping
    public ResponseEntity<List<DeliveryStageResponseDTO>> retrieveAllDeliveryStage()
    {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryStageService.retrieveAllDeliveryStage());
    }

    @PostMapping
    public ResponseEntity<DeliveryStageResponseDTO> insertDeliveryStage(@Valid @RequestBody DeliveryStageRequestDTO dto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryStageService.insertDeliveryStage(dto));
    }

    @GetMapping("/by-parcel-id/{parcelId}")
    public ResponseEntity<List<DeliveryStageDetailsByParcelIdResponseDTO>> retrieveParcelHistory(@PathVariable UUID parcelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryStageService.retrieveDeliveryDetailsByParcelId(parcelId));
    }




}
