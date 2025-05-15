package com.example.deliverySystem.entity;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AccessLevel;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
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

    @Column(nullable=false)
    private LocalDateTime creationTime;

    @Column(nullable=false)
    private LocalDateTime lastModified;

    @OneToMany(mappedBy = "parcel", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DeliveryStage> deliveryStages=new ArrayList<>();

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
