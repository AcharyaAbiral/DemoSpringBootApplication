package com.example.deliverySystem.service;

import com.example.deliverySystem.dto.request.ParcelRequestDTO;
import com.example.deliverySystem.dto.response.ParcelResponseDTO;
import com.example.deliverySystem.entity.Parcel;
import com.example.deliverySystem.entity.User;
import com.example.deliverySystem.mapper.ParcelMapper;
import com.example.deliverySystem.myCustomException.ParcelNotFoundException;
import com.example.deliverySystem.myCustomException.UserNotFoundException;
import com.example.deliverySystem.repository.ParcelRepository;
import com.example.deliverySystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParcelService {
    private final ParcelRepository parcelRepository;
    private final UserRepository userRepository;

    public ParcelResponseDTO insertParcel(ParcelRequestDTO parcelRequestDTO)
    {
        User user=userRepository.findById(parcelRequestDTO.getUserId()).orElseThrow(()->new UserNotFoundException("User of id "+parcelRequestDTO.getUserId()+" does not exist"));
        Parcel mappedParcel=ParcelMapper.mapToParcel(parcelRequestDTO,user);
        return ParcelMapper.mapToParcelResponseDTO(parcelRepository.save(mappedParcel));
    }

    public List<ParcelResponseDTO> retrieveAllParcels(ParcelRequestDTO dto)
    {
        return parcelRepository.findAllByUserId(dto.getUserId())
                .stream()
                .map(ParcelMapper::mapToParcelResponseDTO)
                .collect(Collectors.toList());
    }

    public List<?> searchParcel(ParcelRequestDTO dto)
    {
        if(dto.getCategory()==null)
        {
            return parcelRepository.findByCategoryInitials(dto.getUserId(),"");
        }
        if(dto.getName()==null)
        {
            return parcelRepository.findByCategoryInitials(dto.getUserId(),dto.getCategory());
        }
        else
        {
            return parcelRepository.findByNameInitials(dto.getUserId(),dto.getName());
        }
    }

    public List<ParcelResponseDTO> retrieveParcelDetails(ParcelRequestDTO dto)
    {
        List<Parcel> parcels=parcelRepository.findParcelDetails(dto.getUserId(),dto.getCategory(),dto.getName());
        if(parcels==null){
            throw new ParcelNotFoundException("given parcel does not exist");
        }
        return parcels
                .stream()
                .map(ParcelMapper::mapToParcelResponseDTO)
                .collect(Collectors.toList());
    }
}
