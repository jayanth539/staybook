package com.staybook.dto;

import com.staybook.entity.Hotel;

public record HotelResponse(
        Long id,
        String name,
        String location,
        Double pricePerNight
) {
    public static HotelResponse fromEntity(Hotel hotel) {
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getLocation(),
                hotel.getPricePerNight()
        );
    }
}
