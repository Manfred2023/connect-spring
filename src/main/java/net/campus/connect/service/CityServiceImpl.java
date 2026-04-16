package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    public List<City> getByCountry(Integer countryId) {
        return repository.findByCountryId(countryId);
    }

    @Override
    public City getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}