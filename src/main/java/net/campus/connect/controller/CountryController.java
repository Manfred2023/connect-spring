package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Country;
import net.campus.connect.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<Country>> create(@RequestBody Country country) {
        Country saved = service.save(country);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Country created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Country>>> getAll() {
        List<Country> countries = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Countries retrieved successfully", countries));
    }
}