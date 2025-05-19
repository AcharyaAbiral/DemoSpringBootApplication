package com.example.deliverySystem.controller;

import com.example.deliverySystem.dto.ParcelRequestDTO;
import com.example.deliverySystem.dto.ParcelResponseDTO;
import com.example.deliverySystem.service.ParcelService;
//import org.apache.tomcat.util.http.parser.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@WebMvcTest(ParcelController.class)
public class ParcelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ParcelService parcelService;

    @Test
    void retrieveAllParcels_ShouldReturn200() throws Exception {
        when(parcelService.retrieveAllParcels()).thenReturn(
                List.of(new ParcelResponseDTO(
                                UUID.randomUUID(), "tv", LocalDateTime.now(), LocalDateTime.now())
                        ,
                        new ParcelResponseDTO(
                                UUID.randomUUID(), "laptop", LocalDateTime.now(), LocalDateTime.now()
                        ))
        );

        mockMvc.perform(get("/parcel"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void insertParcel_ShouldReturn201() throws Exception {
        // Create test data
        UUID testId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        String name = "tv";

        // Mock response
        ParcelResponseDTO responseDTO = new ParcelResponseDTO(testId, name, now, now);
        when(parcelService.insertParcel(any(ParcelRequestDTO.class))).thenReturn(responseDTO);

        // Create valid JSON request matching your ParcelRequestDTO structure
        String requestJson = """
        {
            "name":"tv"
        }
        """;

        // Perform and verify
        mockMvc.perform(post("/parcel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(testId.toString()))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.creationTime").exists())
                .andExpect(jsonPath("$.lastModified").exists());
    }

}
