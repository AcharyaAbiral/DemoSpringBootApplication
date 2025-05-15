package com.example.deliverySystem.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(nullable=false,length = 255)
    private String name;

    @Column(nullable = false,length = 255,unique = true)
    private String contactEmail;

    @OneToMany(mappedBy = "destinationLocation",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DeliveryStage> destination=new ArrayList<>();

    @OneToMany(mappedBy = "sourceLocation",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<DeliveryStage>source=new ArrayList<>();

}
