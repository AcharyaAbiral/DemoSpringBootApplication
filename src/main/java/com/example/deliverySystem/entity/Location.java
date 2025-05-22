package com.example.deliverySystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

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

    @Column(nullable=false,length=255)
    private String country;

    @Column(nullable=false,length=255)
    private String city;

    @Column(nullable=false,length=255)
    private String street;

    @Column(nullable = false,length = 255,unique = true)
    private String email;

    @Column(nullable=false,length=10,unique=true)
    private String phone;

    @OneToMany(mappedBy = "destinationLocation",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DeliveryStage> destination=new ArrayList<>();

    @OneToMany(mappedBy = "sourceLocation",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<DeliveryStage>source=new ArrayList<>();

}
