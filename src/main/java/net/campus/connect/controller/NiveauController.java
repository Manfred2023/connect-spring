package net.campus.connect.controller;


import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Niveau;
import net.campus.connect.service.CountryService;
import net.campus.connect.service.NiveauService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveau")
public class NiveauController {

    private final NiveauService service;

    public NiveauController(NiveauService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Niveau>> create(@RequestBody Niveau niveau) {
        Niveau saved = service.save(niveau);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Niveau created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Niveau>>> getAll() {
        List<Niveau> countries = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Niveau retrieved successfully", countries));
    }
}
