//package com.hms.elastic_search_service.entity;
//
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Embeddable;
//
//import java.util.List;
//
//@Embeddable
//public class Room {
//
//    private String roomType;
//    private Double price;
//    private Boolean available;
//
//    @ElementCollection
//    private List<String> amenities; // e.g., ["WiFi", "AC", "Balcony"]
//
//    public Room(String roomType, Double price, Boolean available, List<String> amenities) {
//        this.roomType = roomType;
//        this.price = price;
//        this.available = available;
//        this.amenities = amenities;
//    }
//
//    public String getRoomType() {
//        return roomType;
//    }
//
//    public void setRoomType(String roomType) {
//        this.roomType = roomType;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Boolean getAvailable() {
//        return available;
//    }
//
//    public void setAvailable(Boolean available) {
//        this.available = available;
//    }
//
//    public List<String> getAmenities() {
//        return amenities;
//    }
//
//    public void setAmenities(List<String> amenities) {
//        this.amenities = amenities;
//    }
//}
//
