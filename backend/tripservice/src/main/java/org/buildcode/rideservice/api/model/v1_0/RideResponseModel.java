package org.buildcode.rideservice.api.model.v1_0;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.buildcode.rideservice.api.constants.RideStatus;

import java.math.BigInteger;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RideResponseModel {

    @Schema(description = "Unique identifier for the ride", example = "12345abcde")
    private String id;

    @Schema(description = "Source location of the ride", example = "New York")
    private String source;

    @Schema(description = "Destination location of the ride", example = "Los Angeles")
    private String destination;

    @Schema(description = "User who posted the ride", example = "98nasyu3w423")
    private String userId;

    @Schema(description = "Number of seats", example = "10")
    private BigInteger seats;

    @Schema(description = "vehicleNumber", example = "XADSF000DFA")
    private String vehicleNumber;

    @Schema(description = "Current status of the ride", example = "ACTIVE")
    private RideStatus status;

    @Schema(description = "fare for the ride", example = "1000")
    private BigInteger fare;

    @Schema(description = "Date and time when the ride was created", example = "2024-11-09T12:00:00")
    private Instant createdAt;

    @Schema(description = "Date and time when the ride was last updated", example = "2024-11-09T14:30:00")
    private Instant updatedAt;
}