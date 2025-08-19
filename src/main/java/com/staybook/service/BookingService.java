package com.staybook.service;

import com.staybook.dto.BookingRequest;
import com.staybook.dto.BookingResponse;
import com.staybook.entity.Booking;
import com.staybook.entity.Hotel;
import com.staybook.entity.User;
import com.staybook.repository.BookingRepository;
import com.staybook.repository.HotelRepository;
import com.staybook.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          HotelRepository hotelRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingResponse::fromEntity)
                .toList();
    }

    public BookingResponse createBooking(BookingRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.userId()));

        Hotel hotel = hotelRepository.findById(request.hotelId())
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with id: " + request.hotelId()));

        Booking booking = Booking.builder()
                .checkInDate(request.checkInDate())
                .checkOutDate(request.checkOutDate())
                .user(user)
                .hotel(hotel)
                .build();

        return BookingResponse.fromEntity(bookingRepository.save(booking));
    }

}
