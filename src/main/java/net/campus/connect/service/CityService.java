package net.campus.connect.service;

import net.campus.connect.model.City;

import java.util.List;

public interface CityService {
    City save(City city);
    List<City> getAll();
    List<City> getByCountry(Integer countryId);
    City getById(Integer id);
    void delete(Integer id);
}