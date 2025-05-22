package com.example.deliverySystem.entity;

import com.example.deliverySystem.utils.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.persistence.EnumType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryStage {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "parcel_id", nullable = false)
    private Parcel parcel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "source_location_id", nullable = false)
    private Location sourceLocation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destination_location_id", nullable = false)
    private Location destinationLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status deliveryStatus;

    @Column(name = "time_stamp", nullable = false, updatable = false)
    private LocalDateTime timeStamp;

    @PrePersist
    public void onCreate() {
        this.timeStamp = LocalDateTime.now();
    }
}
