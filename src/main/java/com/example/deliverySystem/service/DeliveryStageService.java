package com.example.deliverySystem.service;

import com.example.deliverySystem.CustomException.LocationNotFoundException;
import com.example.deliverySystem.CustomException.ParcelNotFoundException;
import com.example.deliverySystem.dto.DeliveryStageDetailsByParcelIdResponseDTO;
import com.example.deliverySystem.dto.DeliveryStageRequestDTO;
import com.example.deliverySystem.dto.DeliveryStageResponseDTO;
import com.example.deliverySystem.entity.DeliveryStage;
import com.example.deliverySystem.entity.Location;
import com.example.deliverySystem.entity.Parcel;
import com.example.deliverySystem.mapper.DeliveryStageMapper;
import com.example.deliverySystem.repository.DeliveryStageRepository;
import com.example.deliverySystem.repository.LocationRepository;
import com.example.deliverySystem.repository.ParcelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryStageService {

    private final DeliveryStageRepository deliveryStageRepository;
    private final ParcelRepository parcelRepository;
    private final LocationRepository locationRepository;

    public DeliveryStageResponseDTO insertDeliveryStage(DeliveryStageRequestDTO dto)
    {
//        Parcel parcel=parcelRepository.findById(dto.getParcelId()).orElseThrow(()->new RuntimeException("Parcel not found"));
        Parcel parcel=parcelRepository.findById(dto.getParcelId()).orElseThrow(()->new ParcelNotFoundException("Parcel of id "+dto.getParcelId()+" does not exist."));

//        Location sourceLocation=locationRepository.findById(dto.getSourceLocationId()).orElseThrow(()->new RuntimeException("source location not found"));
        Location sourceLocation=locationRepository.findById(dto.getSourceLocationId()).orElseThrow(()->new LocationNotFoundException("Location of id "+dto.getSourceLocationId()+" does not exist."));

//        Location destinationLocation=locationRepository.findById(dto.getDestinationLocationId()).orElseThrow(()->new RuntimeException("destination location not found"));
        Location destinationLocation=locationRepository.findById(dto.getDestinationLocationId()).orElseThrow(()->new LocationNotFoundException("Location of id "+dto.getDestinationLocationId()+" does not exist."));

        DeliveryStage deliveryStage= DeliveryStageMapper.mapToDeliveryStage(dto,parcel,sourceLocation,destinationLocation);
        return DeliveryStageMapper.mapTODeliveryStageResponseDTO(deliveryStageRepository.save(deliveryStage));
    }

    public List<DeliveryStageResponseDTO> retrieveAllDeliveryStage()
    {
        return deliveryStageRepository.findAll()
                .stream()
                .map(DeliveryStageMapper::mapTODeliveryStageResponseDTO)
                .collect(Collectors.toList());
    }

    public List<DeliveryStageDetailsByParcelIdResponseDTO> retrieveDeliveryDetailsByParcelId(UUID parcelID)
    {
        return deliveryStageRepository.findAllByParcelIdOrderByTimeStampAsc(parcelID)
                .stream()
                .map(DeliveryStageMapper::mapToDeliveryStageDetailsByParcelIdResponseDTO)
                .collect(Collectors.toList());
    }

}
