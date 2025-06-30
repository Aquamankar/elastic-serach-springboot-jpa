package com.hms.elastic_search_service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Optional: One-to-many mapping with areas or hotels
    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<Hotel> hotels;

    // Constructors, getters, setters

    public City() {}

    public City(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Hotel> getHotels() { return hotels; }

    public void setHotels(List<Hotel> hotels) { this.hotels = hotels; }
}
