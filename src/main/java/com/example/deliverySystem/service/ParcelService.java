package com.example.deliverySystem.service;

import com.example.deliverySystem.dto.ParcelRequestDTO;
import com.example.deliverySystem.dto.ParcelResponseDTO;
import com.example.deliverySystem.entity.Parcel;
import com.example.deliverySystem.mapper.ParcelMapper;
import com.example.deliverySystem.repository.ParcelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParcelService {
    private final ParcelRepository parcelRepository;

    public ParcelResponseDTO insertParcel(ParcelRequestDTO parcelRequestDTO)
    {
        Parcel mappedParcel=ParcelMapper.mapToParcel((parcelRequestDTO));
        return ParcelMapper.mapToParcelResponseDTO(parcelRepository.save(mappedParcel));
    }

    public List<ParcelResponseDTO> retrieveAllParcels()
    {
        return parcelRepository.findAll()
                .stream()
                .map(ParcelMapper::mapToParcelResponseDTO)
                .collect(Collectors.toList());
    }
}
