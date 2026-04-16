package net.campus.connect.service;

import net.campus.connect.model.Country;
import net.campus.connect.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return repository.findAll();
    }
}