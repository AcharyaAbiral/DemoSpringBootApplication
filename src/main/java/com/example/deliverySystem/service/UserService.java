package com.example.deliverySystem.service;

import com.example.deliverySystem.dto.request.UserRequestDTO;
import com.example.deliverySystem.dto.response.UserResponseDTO;
import com.example.deliverySystem.entity.User;
import com.example.deliverySystem.mapper.UserMapper;
import com.example.deliverySystem.myCustomException.UserNotFoundException;
import com.example.deliverySystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDTO insertUser(UserRequestDTO userRequestDTO)
    {
        User user= UserMapper.mapToUser(userRequestDTO);
        return UserMapper.mapToUserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO retrieveUserDetailsFromId(UUID id)
    {
        Optional<User>optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            return UserMapper.mapToUserResponseDTO(optionalUser.get());
        }
        else
        {
            throw new UserNotFoundException("user of given id does not exist");
        }
    }

}
