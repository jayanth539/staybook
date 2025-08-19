package com.staybook.dto;

import com.staybook.entity.Booking;
import java.time.LocalDate;

public record BookingResponse(
        Long id,
        LocalDate checkInDate,
        LocalDate checkOutDate,
        String username,
        String hotelName
) {
    public static BookingResponse fromEntity(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getUser().getUsername(),
                booking.getHotel().getName()
        );
    }
}
