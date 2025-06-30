package com.hms.elastic_search_service.service;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import com.hms.elastic_search_service.entity.Area;
import com.hms.elastic_search_service.entity.City;
import com.hms.elastic_search_service.entity.Hotel;
import com.hms.elastic_search_service.entity.HotelDocument;
import com.hms.elastic_search_service.mapper.HotelMapper;
import com.hms.elastic_search_service.payload.HotelDto;
import com.hms.elastic_search_service.repository.AreaRepository;
import com.hms.elastic_search_service.repository.CityRepository;
import com.hms.elastic_search_service.repository.HotelRepository;
import com.hms.elastic_search_service.repository.HotelSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelSearchRepository hotelSearchRepository;

    private final CityRepository cityRepository;
    private final AreaRepository areaRepository;

    public HotelService(HotelRepository hotelRepository, HotelSearchRepository hotelSearchRepository, CityRepository cityRepository, AreaRepository areaRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelSearchRepository = hotelSearchRepository;
        this.cityRepository = cityRepository;
        this.areaRepository = areaRepository;
    }
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchTemplate;
//
//    public List<HotelDocument> searchByAnyField(String keyword) {
//        Query query = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.boolQuery()
//                        .should(QueryBuilders.matchQuery("name", keyword))
//                        .should(QueryBuilders.matchQuery("cityName", keyword))
//                        .should(QueryBuilders.matchQuery("areaName", keyword))
//                        .should(QueryBuilders.matchQuery("postalCode", keyword))
//                ).build();
//
//        SearchHits<HotelDocument> hits = elasticsearchTemplate.search(query, HotelDocument.class);
//
//        return hits.getSearchHits().stream()
//                .map(SearchHit::getContent)
//                .collect(Collectors.toList());
//    }

    public Hotel saveHotel(HotelDto hotelDto) {

        // 1. Get city by name
        City city = cityRepository.findByName(hotelDto.getCityName()).
                orElseGet(()-> {
                    City newCity = new City();
                    newCity.setName(hotelDto.getCityName());

                   return cityRepository.save(newCity);

                } );


        // 2. Get area by name AND by city to ensure relationship
//        Area area = areaRepository.findByName(hotelDto.getAreaName())
//                .orElseGet(() -> {
//                    Area newArea = new Area();
//                    newArea.setName(hotelDto.getAreaName());
//                    newArea.setCity(city);
//
//                    return areaRepository.save(newArea);
//                });
        Area area = areaRepository.findByName(hotelDto.getAreaName())
                .orElseGet(() -> {
                    Area newArea = new Area();
                    newArea.setName(hotelDto.getAreaName());
                    newArea.setCity(city);

                    return areaRepository.save(newArea);
                });


        // 3. Create Hotel entity
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setPostalCode(hotelDto.getPostalCode());
        hotel.setArea(area);
        hotel.setCity(city);

        // 4. Save to relational DB
        Hotel savedHotel = hotelRepository.save(hotel);

        // 5. Save to Elasticsearch
        HotelDocument doc = HotelMapper.toDocument(savedHotel);
        hotelSearchRepository.save(doc);

        return savedHotel;
    }

    public List<HotelDocument> searchByCity(String city) {
        return hotelSearchRepository.findByCityNameIgnoreCase(city);
    }

    public List<HotelDocument> searchByCityAndArea(String city, String area) {
        return hotelSearchRepository.findByCityNameAndAreaName(city, area);
    }

    public List<HotelDocument> searchByName(String name) {
        return hotelSearchRepository.findByNameContainingIgnoreCase(name);
    }

    public List<HotelDocument> searchByPostalCode(String postalCode) {
        return hotelSearchRepository.findByPostalCode(postalCode);
    }

    public  List<HotelDocument> searchByAnyField(String keyword) {
        return hotelSearchRepository.searchHotelOrCityOrAreaOrPostal(keyword);
    }
}

