package net.campus.connect.controller;


import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.City;
import net.campus.connect.model.Filiere;
import net.campus.connect.service.CityService;
import net.campus.connect.service.FiliereService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filiere")
public class FiliereController {
    private final FiliereService service;

    public FiliereController(FiliereService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Filiere>> create(@RequestBody Filiere filiere) {
        System.out.println(filiere.getNiveau());
        Filiere saved = service.save(filiere);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Filiere created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Filiere>>> getAll() {
        List<Filiere> filieres = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Filieres retrieved successfully", filieres));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Filiere>> getById(@PathVariable Integer id) {
        Filiere city = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("Filiere retrieved successfully", city));
    }

    @GetMapping("/niveau/{niveauId}")
    public ResponseEntity<ApiResponse<List<Filiere>>> getByCountry(@PathVariable Integer niveauId) {
        List<Filiere> filieres = service.getByNiveau(niveauId);
        return ResponseEntity.ok(ApiResponse.ok("Filieres retrieved successfully", filieres));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("City deleted successfully", null));
    }
}
