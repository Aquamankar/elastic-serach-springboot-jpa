package com.hms.elastic_search_service.repository;

import com.hms.elastic_search_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByName(String hotelName);
}