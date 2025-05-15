package com.example.deliverySystem.repository;

import com.example.deliverySystem.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParcelRepository extends JpaRepository<Parcel, UUID> {
}
