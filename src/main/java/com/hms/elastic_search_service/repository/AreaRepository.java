package com.hms.elastic_search_service.repository;

import com.hms.elastic_search_service.entity.Area;

import com.hms.elastic_search_service.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByName(String name);
    Optional<Area> findByNameAndCity(String name, City city);

}