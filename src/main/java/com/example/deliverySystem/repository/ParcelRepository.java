package com.example.deliverySystem.repository;

import com.example.deliverySystem.dto.response.ParcelCategoryResponseDTO;
import com.example.deliverySystem.dto.response.ParcelNameResponseDTO;
import com.example.deliverySystem.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ParcelRepository extends JpaRepository<Parcel, UUID> {
    List<Parcel> findAllByUserId(UUID userID);

    @Query("SELECT DISTINCT new com.example.deliverySystem.dto.response.ParcelCategoryResponseDTO(p.category) FROM Parcel p WHERE p.user.Id= :userId AND p.category LIKE CONCAT(:categoryInitials,'%')")
    List<ParcelCategoryResponseDTO> findByCategoryInitials(@Param("userId")UUID userId, @Param("categoryInitials")String categoryInitials);

    @Query("SELECT DISTINCT new com.example.deliverySystem.dto.response.ParcelNameResponseDTO(p.name) FROM Parcel p WHERE p.user.Id= :userId AND p.name LIKE CONCAT(:nameInitials,'%')")
    List<ParcelNameResponseDTO> findByNameInitials(@Param("userId") UUID userId, @Param("nameInitials") String nameInitials);

    @Query("SELECT DISTINCT p from Parcel p where p.user.Id=:userId AND p.category=:category AND p.name=:name")
    List<Parcel> findParcelDetails(@Param("userId")UUID userId,@Param("category")String category,@Param("name")String name);
}
