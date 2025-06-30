package com.hms.elastic_search_service.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



import java.util.List;

@Entity

public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String postalCode;

    @ManyToOne
    @JsonBackReference
    private Area area;

    @ManyToOne
    @JsonBackReference
    private City city;

    public Hotel() {}

    public Hotel(Long id, String name, String postalCode, Area area, City city) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.area = area;
        this.city = city;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public Area getArea() { return area; }

    public void setArea(Area area) { this.area = area; }

    public City getCity() { return city; }

    public void setCity(City city) { this.city = city; }
}

