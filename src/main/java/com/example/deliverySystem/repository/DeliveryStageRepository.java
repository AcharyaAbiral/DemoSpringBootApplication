package com.example.deliverySystem.repository;

import com.example.deliverySystem.entity.DeliveryStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DeliveryStageRepository extends JpaRepository<DeliveryStage, UUID> {
    List<DeliveryStage> findAllByParcelIdOrderByTimeStampAsc(UUID parcelId);
}
