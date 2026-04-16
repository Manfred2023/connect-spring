package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.City;
import net.campus.connect.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<City>> create(@RequestBody City city) {
        City saved = service.save(city);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("City created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<City>>> getAll() {
        List<City> cities = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Cities retrieved successfully", cities));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<City>> getById(@PathVariable Integer id) {
        City city = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("City retrieved successfully", city));
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<ApiResponse<List<City>>> getByCountry(@PathVariable Integer countryId) {
        List<City> cities = service.getByCountry(countryId);
        return ResponseEntity.ok(ApiResponse.ok("Cities retrieved successfully", cities));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("City deleted successfully", null));
    }
}