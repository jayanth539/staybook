package com.staybook.service;

import com.staybook.dto.HotelRequest;
import com.staybook.dto.HotelResponse;
import com.staybook.entity.Hotel;
import com.staybook.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelResponse createHotel(HotelRequest hotelRequest) {
        Hotel hotel = Hotel.builder()
                .name(hotelRequest.name())
                .pricePerNight(hotelRequest.pricePerNight())
                .location(hotelRequest.location())
                .build();
        return HotelResponse.fromEntity(hotelRepository.save(hotel));
    }

    public List<HotelResponse> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelResponse::fromEntity)
                .toList();
    }
}
