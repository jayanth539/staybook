package com.staybook.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookingRequest(
        @NotNull @Future LocalDate checkInDate,
        @NotNull @Future LocalDate checkOutDate,
        @NotNull Long userId,
        @NotNull Long hotelId
) {}
