package com.hms.elastic_search_service.payload;

public class HotelDto {
    private String id;
    private String name;
    private String cityName;
    private String areaName;
    private String postalCode;

    public HotelDto(String id, String name, String cityName, String areaName, String postalCode) {
        this.id = id;
        this.name = name;
        this.cityName = cityName;
        this.areaName = areaName;
        this.postalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
