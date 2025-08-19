package com.staybook.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for hotel creation and update requests.
 */
public record HotelRequest(
        @NotBlank(message = "Hotel name is required")
        String name,

        @NotBlank(message = "Location is required")
        String location,

        @NotNull(message = "Price per night is required")
        @Min(value = 1, message = "Price per night must be positive")
        Double pricePerNight
) {}