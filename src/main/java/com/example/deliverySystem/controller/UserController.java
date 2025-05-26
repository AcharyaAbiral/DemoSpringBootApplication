package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.request.UserRequestDTO;
import com.example.deliverySystem.dto.response.UserResponseDTO;
import com.example.deliverySystem.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> insertUser(@Valid @RequestBody UserRequestDTO userRequestDTO)
    {
        UserResponseDTO userResponseDTO=userService.insertUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping({"/userId"})
    public ResponseEntity<UserResponseDTO> retrieveUserDetails(@PathVariable UUID userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.retrieveUserDetailsFromId(userId));
    }

}
