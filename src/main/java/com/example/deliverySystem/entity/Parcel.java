package com.example.deliverySystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PreUpdate;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AccessLevel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(nullable=false,length=255)
    private String name;

    @Column(nullable=false,length=255)
    private String category;

    @Column(nullable=false)
    private LocalDateTime creationTime;

    @Column(nullable=false)
    private LocalDateTime lastModified;

    @OneToMany(mappedBy = "parcel", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DeliveryStage> deliveryStages=new ArrayList<>();

    @ManyToOne(optional=false)
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @PrePersist
    void onCreate()
    {
        this.creationTime= LocalDateTime.now();
        this.lastModified=LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate()
    {
        this.lastModified=LocalDateTime.now();
    }

}
