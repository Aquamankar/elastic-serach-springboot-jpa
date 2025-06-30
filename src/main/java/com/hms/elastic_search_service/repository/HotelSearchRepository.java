package com.hms.elastic_search_service.repository;

import com.hms.elastic_search_service.entity.HotelDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface HotelSearchRepository extends ElasticsearchRepository<HotelDocument, Long> {

    @Query("""
{
  "bool": {
    "should": [
      { "match": { "name": "?0" }},
      { "match": { "cityName": "?0" }},
      { "match": { "areaName": "?0" }},
      { "match": { "postalCode": "?0" }}
    ]
  }
}
""")
    List<HotelDocument> searchHotelOrCityOrAreaOrPostal(String keyword);


    List<HotelDocument> findByCityNameIgnoreCase(String city);

    List<HotelDocument> findByAreaNameIgnoreCase(String area);

    List<HotelDocument> findByNameContainingIgnoreCase(String name);

    List<HotelDocument> findByPostalCode(String postalCode);

    List<HotelDocument> findByCityNameAndAreaName(String city, String area);
}

