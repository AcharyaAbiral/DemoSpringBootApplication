package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.response.DeliveryStageDetailsByParcelIdResponseDTO;
import com.example.deliverySystem.dto.request.DeliveryStageRequestDTO;
import com.example.deliverySystem.dto.response.DeliveryStageResponseDTO;
import com.example.deliverySystem.service.DeliveryStageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<DeliveryStageResponseDTO>> retrieveAllDeliveryStages()
    {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryStageService.retrieveAllDeliveryStages());
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
