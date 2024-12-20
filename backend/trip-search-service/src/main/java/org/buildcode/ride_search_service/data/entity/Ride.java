// src/main/java/org/buildcode/rideservice/data/entity/Ride.java
package org.buildcode.ride_search_service.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.buildcode.ride_search_service.api.constants.RideStatus;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.Instant;

@Entity
@Table(name = "SearchRides")
@Data
public class Ride {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Column(name = "carModel", nullable = false)
    private String carModel;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RideStatus status;

    @CreatedDate
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @LastModifiedBy
    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) {
            createdAt = Instant.now();
        }
        if (this.updatedAt == null) {
            updatedAt = Instant.now();
        }
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = Instant.now();
    }
}
