package com.staybook.repository;

import com.staybook.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByNameAndLocation(String name, String location);
}
