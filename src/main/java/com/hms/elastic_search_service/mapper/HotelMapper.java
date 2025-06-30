package com.hms.elastic_search_service.mapper;

import com.hms.elastic_search_service.entity.Hotel;
import com.hms.elastic_search_service.entity.HotelDocument;

public class HotelMapper {

    public static HotelDocument toDocument(Hotel hotel) {
        HotelDocument doc = new HotelDocument();
        doc.setId(hotel.getId());
        doc.setName(hotel.getName());
        doc.setPostalCode(hotel.getPostalCode());

        if (hotel.getArea() != null) {
            doc.setAreaName(hotel.getArea().getName());

            if (hotel.getArea().getCity() != null) {
                doc.setCityName(hotel.getCity().getName());
            }
        }

        return doc;
    }
}
