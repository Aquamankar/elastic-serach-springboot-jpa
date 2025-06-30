package com.hms.elastic_search_service.controller;

import com.hms.elastic_search_service.entity.Hotel;
import com.hms.elastic_search_service.entity.HotelDocument;
import com.hms.elastic_search_service.payload.HotelDto;
import com.hms.elastic_search_service.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody HotelDto hotel) {
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @GetMapping("/search/all")
    public ResponseEntity<List<HotelDocument>> searchAllFields(@RequestParam String keyword) {
        return ResponseEntity.ok(hotelService.searchByAnyField(keyword));
    }

    @GetMapping("/search/city")
    public ResponseEntity<List<HotelDocument>> searchByCity(@RequestParam String city) {
        return ResponseEntity.ok(hotelService.searchByCity(city));
    }

    @GetMapping("/search/city-area")
    public ResponseEntity<List<HotelDocument>> searchByCityAndArea(
            @RequestParam String city,
            @RequestParam String area) {
        return ResponseEntity.ok(hotelService.searchByCityAndArea(city, area));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<HotelDocument>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(hotelService.searchByName(name));
    }

    @GetMapping("/search/postal")
    public ResponseEntity<List<HotelDocument>> searchByPostalCode(@RequestParam String postalCode) {
        return ResponseEntity.ok(hotelService.searchByPostalCode(postalCode));
    }
}

