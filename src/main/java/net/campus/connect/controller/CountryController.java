package net.campus.connect.controller;

import net.campus.connect.model.Country;
import net.campus.connect.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        return service.save(country);
    }

    @GetMapping
    public List<Country> getAll() {
        return service.getAll();
    }
}
