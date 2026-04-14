package net.campus.connect.service;

import net.campus.connect.model.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);
    List<Country>getAll();
}
