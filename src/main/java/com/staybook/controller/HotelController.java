package com.staybook.controller;

import com.staybook.dto.HotelRequest;
import com.staybook.dto.HotelResponse;
import com.staybook.entity.Hotel;
import com.staybook.repository.HotelRepository;
import com.staybook.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public HotelResponse createHotel(@Valid @RequestBody HotelRequest hotelRequest) {
        return hotelService.createHotel(hotelRequest);
    }

    @GetMapping
    public List<HotelResponse> getAllHotels() {
        return hotelService.getAllHotels();
    }
}
