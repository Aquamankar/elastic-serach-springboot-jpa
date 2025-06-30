package com.hms.elastic_search_service.entity;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "hotels")
public class HotelDocument {

    @Id
    @org.springframework.data.annotation.Id
    private Long id;

    private String name;
    private String cityName;
    private String areaName;
    private String postalCode;
    public HotelDocument(){}


    public HotelDocument(Long id, String name, String cityName, String areaName, String postalCode) {
        this.id = id;
        this.name = name;
        this.cityName = cityName;
        this.areaName = areaName;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
