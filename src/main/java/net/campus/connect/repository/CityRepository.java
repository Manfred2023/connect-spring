package net.campus.connect.repository;

import net.campus.connect.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByCountryId(Integer countryId);
}