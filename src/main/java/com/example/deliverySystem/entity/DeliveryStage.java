package com.example.deliverySystem.entity;

import com.example.deliverySystem.utils.Status;
import jakarta.persistence.*;
import lombok.*;

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
