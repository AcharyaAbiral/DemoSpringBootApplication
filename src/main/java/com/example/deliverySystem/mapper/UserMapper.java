package com.example.deliverySystem.mapper;

import com.example.deliverySystem.dto.request.UserRequestDTO;
import com.example.deliverySystem.dto.response.UserResponseDTO;
import com.example.deliverySystem.entity.User;

public class UserMapper {
    public static User mapToUser(UserRequestDTO userRequestDTO)
    {
        return User.builder()
                .firstName(userRequestDTO.getFirstName())
                .lastName(userRequestDTO.getLastName())
                .build();
    }

    public static UserResponseDTO mapToUserResponseDTO(User user)
    {
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
